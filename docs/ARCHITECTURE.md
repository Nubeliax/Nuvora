# Architecture — Nuvora

This document describes only the **actual** architecture and technical decisions implemented in the repository as of **Milestone 0**. No future layers or unimplemented components are described here as existing.

## Confirmed Decisions
- **Single-module structure (`:app`)**: The project uses a single Gradle module (`:app`) with package organization by responsibility. Empty packages are not created in advance.
- **Language & Toolchain**: Kotlin `2.1.0`, Android Gradle Plugin `8.7.3`, Gradle `8.11.1`, targeting JVM 17, with `minSdk = 26`, `compileSdk = 35`, and `targetSdk = 35`.
- **UI Toolkit**: Jetpack Compose with Material 3 (managed via `androidx.compose:compose-bom:2024.12.01`).
- **F-Droid Reproducibility & Compliance**:
  - `dependenciesInfo { includeInApk = false; includeInBundle = false }` is configured in `app/build.gradle.kts` to avoid embedding proprietary Google signing metadata blocks.
  - All dependencies are free/libre software (Apache-2.0 / EPL-1.0) compatible with `GPL-3.0-or-later`.
- **Security & Manifest**:
  - Zero permissions declared in Milestone 0.
  - Cleartext traffic explicitly disabled (`android:usesCleartextTraffic="false"`).
  - Supported locales (`en`, `es`) declared in `res/xml/locales_config.xml` and linked via `android:localeConfig`.

## Current Package Structure (`app/src/main/java/io/github/nubeliax/nuvora`)
- `io.github.nubeliax.nuvora`:
  - `MainActivity.kt` — Entry-point `ComponentActivity` hosting `PlaceholderScreen()`, which renders localized placeholder text using Material 3 components.
- `io.github.nubeliax.nuvora.ui.theme`:
  - `Theme.kt` — `NuvoraTheme` composable providing light and dark Material 3 color schemes.

## Current Test Structure (`app/src/test/java/io/github/nubeliax/nuvora`)
- `FoundationSanityTest.kt` — Deterministic unit tests verifying the JUnit 4 and `kotlinx-coroutines-test` (`runTest`) setup.
