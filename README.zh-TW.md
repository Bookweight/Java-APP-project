# Java 每日行程規劃程式

[![Language](https://img.shields.io/badge/%E4%B8%AD%E6%96%87-English-white?labelColor=2ea44f&style=flat)](README.md)
[![Java CI](https://github.com/Bookweight/Java-APP-project/actions/workflows/ci.yml/badge.svg)](https://github.com/Bookweight/Java-APP-project/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://openjdk.org/projects/jdk/17/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

一個以 Java Swing 打造的桌面應用程式，用於管理並模擬五大生活面向的每日行程。UI 採用 **FlatLaf** 現代化主題與 **MigLayout** 自適應排版，提供乾淨、扁平化的使用者體驗。

---

## 功能特色

- **五大生活面向**：學業、興趣、運動、社交、感情分類管理。
- **自訂比重**：為每個面向與子項目設定 1–5 的優先權重。
- **行程進度檢視**：以進度條顯示各類別的完成狀況。
- **每日模擬排程**：依照設定的比重，每日隨機選出 3 項任務並儲存結果。
- **動態視窗縮放**：GUI 尺寸自動依照螢幕解析度調整。
- **現代化 UI**：採用扁平化設計、圓角按鈕、滑鼠懸停動畫，以及乾淨的淺色主題（由 [FlatLaf](https://www.formdev.com/flatlaf/) 驅動）。

---

## 技術棧

| 類別 | 技術 |
|------|------|
| 語言 | Java 17 |
| GUI 框架 | Java Swing |
| 視覺主題 | FlatLaf 3.2.5 |
| 排版管理 | MigLayout 11.3 |
| 建置工具 | Apache Maven |
| 程式碼格式化 | Google Java Format (Spotless) |
| 命名規範檢查 | Checkstyle (Google Checks) |
| CI/CD | GitHub Actions |

---

## 專案目錄結構

```
src/
├── main/
│   ├── java/GUI/
│   │   ├── MainGUI.java              # 應用程式進入點與主視窗
│   │   ├── ScheduleGUI.java          # 行程進度檢視畫面
│   │   ├── FiveFacesSettingGUI.java  # 五大面向比重設定
│   │   ├── SimulationGUI.java        # 模擬啟動與結果查看
│   │   ├── Theme.java                # 集中管理色盤與字體
│   │   ├── CustomButton.java         # 圓角按鈕（含懸停動畫）
│   │   ├── ImageUtil.java            # 圖片載入共用工具類別
│   │   ├── ThreeFunctionButtons.java # 可重用的底部操作按鈕列
│   │   └── DynamicSizing.java        # 螢幕尺寸動態縮放
│   └── resources/GUI/Icons/          # 所有圖示資源 (PNG)
.github/workflows/ci.yml             # GitHub Actions CI 流程設定
pom.xml                              # Maven 建置與插件設定
```

---

## 開始使用

### 環境需求

- Java 17+
- Maven 3.6+（或使用專案內附的 `mvnw.cmd` Wrapper，無需額外安裝）

### 執行應用程式

```bash
# 使用 Maven Wrapper（無需本機安裝 Maven）
.\mvnw.cmd exec:java -Dexec.mainClass="GUI.MainGUI"

# 或使用已安裝的 Maven
mvn exec:java -Dexec.mainClass="GUI.MainGUI"
```

### 本地端程式碼品質檢查

```bash
# 自動套用 Google Java 格式化風格
mvn spotless:apply

# 執行命名規範檢查
mvn checkstyle:check
```

---

## UI 架構設計

所有視窗均採用 **MigLayout** 取代舊有的 `setLayout(null)` /`setBounds()` 絕對座標定位，確保介面在不同螢幕尺寸下都能自適應縮放。

共用樣式集中於兩個工具類別：
- **`Theme.java`** — 定義完整色盤（主色、各面向顏色、文字色、背景色）及共用 `Font` 字體物件。
- **`CustomButton.java`** — 繼承 `JButton` 的自訂按鈕，支援可調圓角半徑、透明背景，以及平滑的滑鼠懸停色彩變化。

---

## CI / Pre-commit Hook

- **GitHub Actions** (`.github/workflows/ci.yml`)：每次 push 或 pull request 時，自動執行 `spotless:check`、`checkstyle:check` 與 `mvn package` 進行驗證。
- **Pre-commit Hook** (`.git/hooks/pre-commit`)：在每次提交前於本地端自動執行 `spotless:apply` 與 `checkstyle:check`（需要系統中已安裝 Java）。
