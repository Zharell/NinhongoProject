package com.ninhongo.interceptor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {
	
	private final ConcurrentMap<String, RateLimiter> limiters = new ConcurrentHashMap<>();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//Obtenemos el ID del cliente (Se obtiene la IP)
        String clientId = getClientId(request);
        
        RateLimiter rateLimiter = limiters.computeIfAbsent(clientId, k -> new RateLimiter(20, TimeUnit.MINUTES));
        if (!rateLimiter.allowRequest()) {
            response.setStatus(429);
            response.getWriter().write("Too many requests. Please try again later.");
            return false;
        }
        return true;
    }
	
	// Clase interna RateLimiter
    static class RateLimiter {
        private final int maxRequests;
        private final long timeWindowMillis;
        private long windowStart;
        private int requestCount;

        public RateLimiter(int maxRequests, TimeUnit timeWindowUnit) {
            this.maxRequests = maxRequests;
            this.timeWindowMillis = timeWindowUnit.toMillis(1);
            this.windowStart = System.currentTimeMillis();
            this.requestCount = 0;
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();
            if (now - windowStart > timeWindowMillis) {
                windowStart = now;  // Reiniciar el inicio de la ventana de tiempo
                requestCount = 0;   // Reiniciar el contador de solicitudes
            }
            if (requestCount < maxRequests) {
                requestCount++;
                return true;  // Permitir la solicitud
            }
            return false;  // Rechazar la solicitud
        }
    }
	
    private String getClientId(HttpServletRequest request) {    	
        return request.getRemoteAddr();
    }
	
}