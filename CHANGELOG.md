# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Initial Android project foundation (`:app` module, Kotlin, Jetpack Compose, Material 3, `minSdk 26`).
- Pinned Gradle Wrapper (`8.11.1` with SHA-256 verification) and version catalog (`gradle/libs.versions.toml`).
- Placeholder initial screen using string resources only, with no weather functionality yet.
- Base internationalization for English (`values`) and Spanish (`values-es`), `locales_config.xml`, and `MissingTranslation` configured as a Lint error.
- Unit test setup with JUnit 4 and `kotlinx-coroutines-test`.
- GitHub Actions CI workflow running wrapper validation, unit tests, Lint, and debug APK assembly.
- Project documentation (`README.md`, `PRIVACY.md`, `CONTRIBUTING.md`, `AGENTS.md`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/WEATHER_RULES.md`) and base Fastlane metadata (`en-US` and `es-MX`).
