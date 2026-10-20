# AGENTS.md — Guía para Agentes en Nuvora

## 1. Resumen del proyecto
**Nuvora** es una aplicación Android de software libre que traduce datos meteorológicos en información sencilla, clara y honesta. No promete certezas donde solo hay pronósticos ni recopila datos del usuario.

## 2. Decisiones confirmadas (inmutables sin consulta explícita)
- **Lenguaje**: Kotlin.
- **UI**: Jetpack Compose + Material 3.
- **Estructura**: Un solo módulo (`:app`), organizado en paquetes por responsabilidad. No se crean paquetes ni carpetas vacías "para el futuro".
- **SDK mínimo**: `minSdk = 26`.
- **Identificador de aplicación**: `io.github.nubeliax.nuvora`.
- **Licencia**: `GPL-3.0-or-later`. Todo archivo fuente Kotlin debe comenzar con la cabecera `// SPDX-License-Identifier: GPL-3.0-or-later`. Todas las dependencias deben tener licencias libres compatibles con GPL-3.0-or-later.
- **Fuente meteorológica**: Open-Meteo (se integrará en el Hito correspondiente; no adelantarse).
- **Repositorio y CI**: GitHub + GitHub Actions.
- **Distribución objetivo**: F-Droid (`dependenciesInfo { includeInApk = false; includeInBundle = false }`, sin blobs binarios no auditables ni servicios propietarios como Google Play Services).

## 3. Límites de privacidad y seguridad
- Cero analítica, telemetría, publicidad, rastreadores o SDKs propietarios.
- Sin cuentas ni backend propio sin aprobación explícita.
- Solo se declaran permisos estrictamente necesarios para el hito actual (en el Hito 0, cero permisos). El permiso `INTERNET` se añadirá únicamente cuando se utilice (Hito 2).
- Ubicación solo con `LocationManager` de la plataforma Android, nunca Fused Location ni Google Play Services; sin ubicación en segundo plano; la selección manual de ciudad debe funcionar sin permisos de ubicación.
- Antes de integrar cualquier API o biblioteca, verificar que su licencia sea compatible con `GPL-3.0-or-later`, así como sus condiciones de uso, atribución y límites.
- `android:usesCleartextTraffic="false"` explícito en el manifiesto.
- En CI solo se usan acciones oficiales (`actions/*`, `gradle/*`) con licencia libre; `gradle/actions/setup-gradle` debe usar `cache-provider: basic` mientras el caching por defecto sea propietario.
- Nunca subir `local.properties`, keystores, credenciales ni secretos al repositorio.

## 4. Reglas de internacionalización (i18n)
- Idiomas base soportados desde el inicio: inglés (`res/values/strings.xml`, idioma por defecto) y español (`res/values-es/strings.xml`).
- Ambos archivos deben mantener exactamente el mismo conjunto de claves.
- **Cero cadenas visibles al usuario codificadas directamente (hardcoded) en Kotlin/Compose**. Todo texto visible debe provenir de recursos (`stringResource`).
- Prohibido concatenar frases en código: utilizar argumentos de formato posicionales y `plurals.xml`.
- Las explicaciones meteorológicas se generan desde claves/recursos traducibles y las reglas meteorológicas son independientes del idioma.
- Formatear fechas, horas, números y unidades con `Locale`/`java.time` respetando siempre la zona horaria del lugar consultado.
- La regla de Lint `MissingTranslation` debe mantenerse con severidad `error` (`fatal`).
- `res/xml/locales_config.xml` referenciado mediante `android:localeConfig` en `AndroidManifest.xml`.

## 5. Reglas de pruebas (Testing)
- Toda lógica añadida debe contar con pruebas unitarias deterministas. Las pruebas se escriben junto con la regla o antes.
- **Prohibido borrar, comentar, marcar con `@Ignore` o debilitar aserciones de pruebas existentes** para hacer pasar la suite. Prohibido también modificar el comportamiento esperado de un test para que pase (si se cree que un test es incorrecto, explicarlo y pedir aprobación).
- Cada corrección de bug debe incluir una prueba de regresión que fallaba antes de la corrección.
- Pruebas deterministas, sin red real, y con reloj (`Clock`) y red inyectables.
- En la capa de datos, usar fixtures JSON en `src/test/resources/` y `MockWebServer`.
- En pruebas con corrutinas, utilizar `kotlinx-coroutines-test` (`runTest`).
- No añadir bibliotecas de prueba sin justificación; declararlas solo en `test`/`androidTest` y siempre con licencia libre.

## 6. Comandos exactos de verificación
La verificación estándar del proyecto (y referencia en CI) se ejecuta con:
```bash
./gradlew --version
./gradlew testDebugUnitTest lintDebug assembleDebug
```
Verificaciones adicionales de higiene del repositorio:
```bash
git status
git ls-files
grep -n "uses-permission\|usesCleartextTraffic\|localeConfig" app/src/main/AndroidManifest.xml
```

## 7. Reglas de Git y flujo de trabajo
- Leer `AGENTS.md` y la documentación pertinente antes de modificar cualquier archivo, e inspeccionar el estado real del repositorio antes de actuar.
- **No hacer `git commit`, `git push`, ni crear ramas, tags o releases** a menos que el usuario lo pida de forma explícita. Dejar siempre los cambios en el árbol de trabajo para revisión.
- **No adelantarse a tareas o hitos futuros** ni avanzar de hito sin aprobación expresa: implementar únicamente lo solicitado en el hito activo.
- Las reglas meteorológicas viven en `docs/WEATHER_RULES.md` y se definen al implementar cada función.
- Mantener el catálogo de versiones (`gradle/libs.versions.toml`) con versiones fijas (prohibido usar `+`, rangos o `latest`). No actualizar versiones por rutina sin justificación.

## 8. Nota sobre el entorno Termux
- El desarrollo e inspección local pueden realizarse desde Termux en Android (`aarch64`).
- En Termux, la ejecución de Gradle/Android SDK o `aapt2` puede fallar por falta de JDK local, SDK de Android o incompatibilidad de binarios `x86_64`.
- **Nunca confirmar en el repositorio parches o workarounds específicos de Termux** (como rutas locales en `gradle.properties` o binarios alternativos de `aapt2`). Si una validación de compilación falla por limitaciones del entorno Termux, debe reportarse con el error exacto; la verificación de referencia para compilación es GitHub Actions.

## 9. Formato del informe al finalizar tareas
Cada entrega de hito o tarea debe incluir un informe estructurado con:
1. Resumen conciso de lo realizado.
2. Árbol o lista de archivos creados/modificados.
3. Versiones o dependencias tocadas (con licencia y justificación si hubo cambios).
4. Salida real de cada validación, separando claramente entre **EJECUTADAS** (comando + salida real + recuento de tests) y **NO EJECUTADAS / FALLIDAS POR ENTORNO** (con motivo y diagnóstico honesto).
5. Elementos pendientes, desviaciones y dudas que requieran decisión del usuario.
6. Confirmación explícita de no haber ejecutado `commit`/`push` ni adelantado trabajo de hitos futuros.
