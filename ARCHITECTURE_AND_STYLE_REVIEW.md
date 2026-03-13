# 專案架構與程式碼風格優化建議 (Architecture & Code Style Review)

在檢視了目前的 Java 日常行程規劃專案後，總結出以下幾個架構與程式碼寫作風格的優化建議，幫助專案更容易維護、擴展與除錯。

## 一、 系統架構優化建議 (Architecture Improvements)

### 1. 導入 MVC (Model-View-Controller) 架構
- **現狀**：所有的業務邏輯（Business Logic，例如時數計算、模擬機率）和圖形介面（GUI）程式碼都混寫在 `JFrame` 類別中（例如 `MainGUI.java`, `ScheduleGUI.java` 等）。
- **建議**：
  - **Model (模型)**：建立獨立的實體類別來負責資料與邏輯，例如 `Category`, `SubTask`, `SimulationEngine` 等，完全不用依賴 GUI 套件（`javax.swing`）。
  - **View (視圖)**：目前的 GUI 程式碼只應負責「顯示畫面」與「接收事件」，切勿在按鈕的 `ActionListener` 裡直接寫死權重計算或資料庫存取邏輯。
  - **Controller (控制器)**：作為 Model 和 View 的橋樑，負責接收 View 的指令、改變 Model 狀態，然後更新 View。

### 2. 視窗導覽方式 (Window Navigation) 改良
- **現狀**：目前切換視窗的方式是不斷 `new XxxGUI()` 並呼叫 `appFrame.dispose()` 來銷毀舊視窗。這不僅會造成畫面閃爍、重新載入資源拖慢效能，也難以在視窗間共享狀態資料。
- **建議**：
  - 使用 **`CardLayout`** 管理同一個 `JFrame` 內的多個 `JPanel`（頁面）。這樣主視窗只需要建立一次，切換頁面時只是切換顯示的 Panel，效能更好且狀態容易在一個主容器中保留。

### 3. 使用適當的版面配置管理員 (Layout Managers)
- **現狀**：大量使用了 `appFrame.setLayout(null);` 以及絕對座標 `setBounds`，並藉由 `DynamicSizing` 將比例乘以畫面長寬來定位。這在視窗縮放或跨平台字體不同時，極易發生跑版或文字被截斷的問題。
- **建議**：
  - 盡可能使用相對佈局管理，如 `BorderLayout`, `GridLayout`, `GridBagLayout`，或是第三方好用的佈局如 `MigLayout`。這能免去大量手動計算座標的麻煩，且視窗具有更好的動態排版彈性。

## 二、 程式碼寫作風格優化建議 (Code Style Improvements)

### 1. 遵守 Java 命名慣例 (Naming Conventions)
- **現狀**：部分變數或類別名稱出現拼字錯誤，例如 `socailButton` (應為 `socialButton`), `ImplimentGUI.java` (應為 `ImplementGUI.java`)。
- **建議**：
  - 類別名稱使用 **PascalCase** 首字母大寫（目前大多已吻合）。
  - 變數與方法使用 **camelCase** 駝峰式命名，例如 `schedulebButton` 應改為 `scheduleButton`，避免無意義的字母。
  - 建議善用 IDE（例如 Eclipse, IntelliJ IDEA）的拼字檢查及重新命名 (Rename/Refactor) 功能進行統一修改。

### 2. 減少重複程式碼 (DRY - Don't Repeat Yourself)
- **現狀**：在每個 GUI 類別（如 `MainGUI`, `ScheduleGUI`, `FiveFacesSettingGUI`）裡面都重複撰寫了 `loadIcons()` 載入圖片的方法以及多次重複的異常處理機制（`try-catch`）。
- **建議**：
  - 建立一個獨立的資源管理類別（任務例如 `ImageUtil`），裡面實作靜態方法 `public static ImageIcon getScaledIcon(String path, int width, int height)` 以提供全域存取。
  - 不論是載入背景還是按鈕圖片，只要呼叫一行程式碼即可，不必在每一個畫面中重複撰寫大量一模一樣的 `ImageIO.read` 與 Exception 處理。

### 3. 優化異常捕捉 (Exception Handling)
- **現狀**：目前許多圖片載入失敗時，只印出單調的 `System.out.println("...:" + e);`。
- **建議**：
  - 開發階段應印出完整的堆疊追蹤資訊（`e.printStackTrace()`）或是導入 `java.util.logging` 等日誌系統，方便追蹤錯誤來源。
  - 在無法讀取 GUI 圖片等重要資源時，應該要有替代的文字備用方案（Text Fallback）或彈出 `JOptionPane` 錯誤視窗告知開發者/使用者資源遺失，而非只是默默印在 Console 然後導致畫面顯示不全。

### 4. 避免過多的強制型別轉換 (Type Casting for Layout calculations)
- **現狀**：充滿了 `(int) Math.round(640 * w)` 這種程式碼，影響可讀性。
- **建議**：
  - 可先將計算功能封裝入 `DynamicSizing` 的工具方法中，例如透過 `DynamicSizing.getScaledW(640)` 回傳已處理好的整數，讓建立 UI 元件的程式碼保持簡潔美觀。

---

> 總結：目前的專案已經具備一個圖形化介面的雛形，但如果要將專案擴建為一個具備完整邏輯、容易維護的商用級別或進階專案，首要之務會是將「演算／資料處理邏輯」從「畫面呈現（JFrame）」中抽離。搭配更好的變數命名與資源管理技巧，會讓整體的 Java 程式碼質感大幅提升！
