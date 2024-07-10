# Ninhongo Project

Ninhongo Project con JMDict y KanjiDict.

API para obtener palabras y kanjis en japonés y practicar el idioma.

La API se encuentra desarrollada y funcional, se espera que no tenga caídas teniendo en cuenta que, los cambios se realizarán en horas con poca carga.

¡Escuchamos vuestras ideas!

## Endpoints:

### Palabra del día

```
OK GET api.ninhongo.com/v1/wotd - Devuelve la palabra japonesa del día.
OK GET api.ninhongo.com/v1/rword - Devuelve una palabra aleatoria.
```

### Kanji del día

```
OK GET api.ninhongo.com/v1/kotd - Devuelve el kanji del día.
OK GET api.ninhongo.com/v1/rkanji - Devuelve un kanji aleatoria.
```

### Palabra kana del día (No tiene kanji)

```
OK GET api.ninhongo.com/v1/nkotd - Devuelve una palabra Kana del día.
OK GET api.ninhongo.com/v1/rnkanji - Devuelve una palabra Kana aleatoria.
```

### Opcionales (en desarrollo):

```
OK GET api.ninhongo.com/v1//wotd/{KANJI/PALABRA} - Devuelve información el kanji o palabra enviada
```

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, abre un issue o un pull request.

## Licencia

Este proyecto está bajo la licencia MIT.
