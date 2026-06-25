# CHANGELOG

## 2026-06-24 - Production Cleanup and Refactor (Canonical Scope)

### Scope
- Canonical backend scope: `code/software_technik_2-main`
- Canonical frontend scope: `frontend/software_technik_2/shsfrontendla`
- Workspace-level duplicate cleanup: legacy parallel project folders removed.

### Backend Refactors
- Refactored SHS bootstrap flow in `code/software_technik_2-main/SHS/src/main/java/com/renewableenergy/SHS/ShsApplication.java`:
  - Removed infinite MQTT subscribe loop behavior.
  - Simplified startup path and retained single topic subscription.
  - Removed large blocks of commented legacy code.
- Refactored SGS bootstrap flow in `code/software_technik_2-main/SGS/src/main/java/com/renewableenergy/SGS/SgsApplication.java`:
  - Removed unused imports/legacy code.
  - Simplified scheduler startup sequence.
- Refactored weather app bootstrap in `code/software_technik_2-main/mqtt-spring-broker-master/src/main/java/WeatherPortal/WeatherPortal/MqttJavaApplication.java`:
  - Removed infinite loop and static/autowired misuse patterns.
  - Switched to one-time subscribe path.

### Security and Configuration Hardening
- Replaced hardcoded DB connection values with environment-variable placeholders:
  - `code/software_technik_2-main/SHS/src/main/resources/application.properties`
  - `code/software_technik_2-main/SGS/src/main/resources/application.properties`
- Externalized MQTT config values (host, port, username, password, qos) to environment-backed defaults:
  - `code/software_technik_2-main/SHS/src/main/java/com/renewableenergy/SHS/MQTT/MqttConfig.java`
  - `code/software_technik_2-main/SGS/src/main/java/Mqtt/MqttConfig.java`
  - `code/software_technik_2-main/mqtt-spring-broker-master/src/main/java/WeatherPortal/WeatherPortal/Config/MqttConfig.java`
- Fixed credential bug in MQTT subscribers where password was incorrectly used as username.
- Hardened weather API integration in `code/software_technik_2-main/mqtt-spring-broker-master/src/main/java/WeatherPortal/WeatherPortal/service/WeatherService.java`:
  - Replaced hardcoded RapidAPI key usage with `WEATHER_API_KEY` lookup.
  - Removed response debug print to stdout.
  - Improved exception handling (`InterruptedException` restore + runtime propagation, `IOException` propagation).

### Dependency Cleanup
- Removed duplicate/unnecessary dependencies from:
  - `code/software_technik_2-main/SGS/pom.xml`
  - `code/software_technik_2-main/mqtt-spring-broker-master/pom.xml`
- Notably removed duplicate `httpclient` and unnecessary `spring-integration-mqtt` declarations.

### Frontend Fixes
- Fixed Angular routes/navigation and API integration wiring in:
  - `frontend/software_technik_2/shsfrontendla/src/app/app-routing.module.ts`
  - `frontend/software_technik_2/shsfrontendla/src/app/app.component.html`
  - `frontend/software_technik_2/shsfrontendla/src/app/add-devices/add-devices.component.html`
  - `frontend/software_technik_2/shsfrontendla/src/app/add-devices/add-devices.component.ts`
  - `frontend/software_technik_2/shsfrontendla/src/app/homepage/homepage.component.ts`

### Deletions
- Removed dead classes/files:
  - `WeatherDataService`
  - `MQTTWeather`
  - `MqttMessageListener`
  - `WeatherAPIExample` (SGS API package)
- Removed duplicate non-source API folder:
  - `code/software_technik_2-main/API`
- Removed generated/temp artifacts in canonical tree where safe.
- Removed major duplicate legacy workspace folders:
  - `SHS`
  - `git/software_technik_2`
  - `projekt/marven`
  - `projekt/SHS`
  - `projekt/RenewableEnergy`
  - `Project-01`
  - `last_one`

### Validation
- Static diagnostics (`get_errors`) for canonical Java and frontend app paths: no reported code errors.
- Build/compile validation is blocked in this environment:
  - `npm` is not installed/available.
  - `JAVA_HOME` is not configured, so Maven wrapper compile cannot execute.
