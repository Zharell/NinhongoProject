# NinhongoProject

Ninhongo Project con JMDict y KanjiDict.

API para obtener palabras y kanjis en japonés y practicar el idioma.

La API se encuentra en desarrollo y se espera que esté disponible en entorno productivo para septiembre.

Escuchamos vuestras ideas!

La API estará disponible en https://ninhongo.com

Endpoints:

Palabra del día

    OK GET api.ninhongo.com/v1/wotd - Devuelve la palabra japonesa del día.
    OK GET api.ninhongo.com/v1/rwotd - Devuelve una palabra aleatoria.

Kanji del día
    
    OK GET api.ninhongo.com/v1/wotk - Devuelve el kanji del día.
    OK GET api.ninhongo.com/v1/rwotk - Devuelve un kanji aleatoria.

Palabra kana del día (No tiene kanji)

    OK GET api.ninhongo.com/v1/wotnk - Devuelve una palabra Kana del día.
    OK GET api.ninhongo.com/v1/rwotnk - Devuelve una palabra Kana aleatoria.

Opcionales:

    KO GET api.ninhongo.com/v1//wotd/{KANJI/PALABRA} - Devuelve información el kanji o palabra enviada

Contribuciones

¡Las contribuciones son bienvenidas! Por favor, abre un issue o un pull request.
Licencia

Este proyecto está bajo la licencia MIT.
