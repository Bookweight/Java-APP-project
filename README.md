# Java Daily Schedule Planner

[![Language](https://img.shields.io/badge/English-%E4%B8%AD%E6%96%87-white?labelColor=2ea44f&style=flat)](README.zh-TW.md)
[![Java CI](https://github.com/Bookweight/Java-APP-project/actions/workflows/ci.yml/badge.svg)](https://github.com/Bookweight/Java-APP-project/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://openjdk.org/projects/jdk/17/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A Java Swing desktop application for managing and simulating your daily schedule across five life domains. Built with a modern, responsive UI powered by **FlatLaf** and **MigLayout**.

---

## Features

- **Five Life Domains**: Manage tasks across Academic, Hobby, Sport, Social, and Relationship categories.
- **Custom Weighting**: Assign priorities (1–5) to each domain and sub-task.
- **Schedule Progress View**: Track completion progress per category with live progress bars.
- **Daily Simulation**: Randomly selects 3 daily tasks based on your configured weights; stores simulation results.
- **Dynamic Scaling**: UI scales automatically to your screen resolution.
- **Modern UI**: Flat design with rounded-corner custom buttons, hover animations, and a clean light theme (powered by [FlatLaf](https://www.formdev.com/flatlaf/)).

---

## Tech Stack

| Component | Technology |
|-----------|-----------|
| Language | Java 17 |
| GUI Framework | Java Swing |
| Look & Feel | FlatLaf 3.2.5 |
| Layout Manager | MigLayout 11.3 |
| Build Tool | Apache Maven |
| Code Style | Google Java Format (Spotless) |
| Naming Checks | Checkstyle (Google Checks) |
| CI | GitHub Actions |

---

## Project Structure

```
src/
├── main/
│   ├── java/GUI/
│   │   ├── MainGUI.java          # Application entry point & main window
│   │   ├── ScheduleGUI.java      # Schedule progress view
│   │   ├── FiveFacesSettingGUI.java  # Weight configuration per domain
│   │   ├── SimulationGUI.java    # Simulation launcher & result viewer
│   │   ├── Theme.java            # Centralized color palette & fonts
│   │   ├── CustomButton.java     # Rounded button with hover animations
│   │   ├── ImageUtil.java        # Centralized image loading utility
│   │   ├── ThreeFunctionButtons.java  # Reusable bottom action bar
│   │   └── DynamicSizing.java    # Screen-aware size scaling
│   └── resources/GUI/Icons/      # All icon assets (PNG)
.github/workflows/ci.yml          # GitHub Actions CI pipeline
pom.xml                           # Maven build & plugin configuration
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+ (or use the included `mvnw`/`mvnw.cmd` wrapper)

### Run the Application

```bash
# Using Maven Wrapper (no Maven installation required)
./mvnw exec:java -Dexec.mainClass="GUI.MainGUI"

# Or with system Maven
mvn exec:java -Dexec.mainClass="GUI.MainGUI"
```

### Code Quality Checks (Local)

```bash
# Auto-format code to Google Java Style
mvn spotless:apply

# Enforce naming convention checks
mvn checkstyle:check
```

---

## UI Architecture

All GUI windows use **MigLayout** instead of hardcoded `setBounds()`, ensuring that the layout adapts cleanly to different screen sizes.

Shared styling is centralized in two utility classes:
- **`Theme.java`** — Defines the complete color palette (primary, category colors, text, backgrounds) and the shared `Font` objects.
- **`CustomButton.java`** — A `JButton` subclass with rounded corners (configurable radius), transparent background, and smooth hover color transitions.

---

## CI / Pre-commit Hooks

- **GitHub Actions** (`.github/workflows/ci.yml`): On every push or pull request, automatically runs `spotless:check`, `checkstyle:check`, and `mvn package`.
- **Pre-commit hook** (`.git/hooks/pre-commit`): Runs `spotless:apply` + `checkstyle:check` locally before each commit (requires Java in `PATH`).
