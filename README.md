# Java Backend Coding Challenge: Product Filter, Aggregator & Logger API

Welcome to the live coding interview! This repository is a pre-configured Spring Boot starter project designed to help you complete the challenge within 20-30 minutes without wasting time on boilerplate setup.

歡迎來到上機實作面試！本專案是一個預先配置好的 Spring Boot 骨架，旨在幫助您在 20-30 分鐘內完成測驗，無需將時間花費在繁瑣的基礎環境設定上。

---

## 🔗 Challenge Specification / 測驗詳細規格
The detailed specification, expected JSON response formats, and evaluation criteria are available on the wiki page:  
詳細的 API 規格、預期 JSON 響應格式及評分標準請參閱 Wiki 頁面：

👉 **[Java Backend Coding Challenge Specification (Wiki Link)](https://wiki.david888.com/share/7d186b781ebbfc22ff79614ea049ab66)**

---

## 📁 Repository Overview / 專案結構概覽
The boilerplate setup has been completed for you:  
以下基礎設置已為您準備妥當：

- **Environment**: Spring Boot 3.3.x with Java 17+ and in-memory H2 Database configuration.  
  **環境配置**：Spring Boot 3.3.x、Java 17+ 以及 H2 記憶體資料庫配置。
- **HTTP Client**: `DummyJsonProductClient` is fully implemented and fetches products from the external DummyJSON API.  
  **HTTP 客戶端**：`DummyJsonProductClient` 已完整實作，可直接獲取外部 DummyJSON API 的商品資料。
- **DAO & DB Log**: `SearchQueryLog` JPA Entity and `SearchQueryLogRepository` (DAO) are already implemented.  
  **資料庫日誌層**：`SearchQueryLog` JPA 實體與 `SearchQueryLogRepository` (DAO) 已寫好。
- **Global Error Handling**: `GlobalExceptionHandler` and `NoProductsFoundException` are pre-wired.  
  **全域異常處理**：`GlobalExceptionHandler` 與 `NoProductsFoundException` 已配置完成。

---

## 🛠️ Your Tasks / 您的實作任務
Please implement the missing logic marked with `TODO` in the following files:  
請在以下檔案中尋找 `TODO` 標記並完成未實作的邏輯：

1.  **Service Layer**: `com.example.interview.service.ProductService`
    *   Filter products (exclude products where `price < minPrice`).  
        **過濾商品**：排除價格小於 `minPrice` 的商品。
    *   Aggregate statistics (calculate `averagePrice` and `maxDiscount` of the filtered products).  
        **聚合統計**：計算過濾後商品的平均價格 (`averagePrice`) 與最大折扣 (`maxDiscount`)。
    *   Sort the filtered products in descending order based on `sortBy` (`price`, `rating`, or `discount`).  
        **商品排序**：依據 `sortBy` 參數，對商品清單進行**降序 (descending)** 排序。
    *   Save search query metadata to the local H2 database using the repository and retrieve the generated log ID.  
        **寫入日誌**：使用 Repository 將搜尋的關鍵字、過濾條件與匹配數量存入本機 H2 資料庫，並獲取生成的主鍵 ID。

2.  **Controller Layer**: `com.example.interview.controller.ProductController`
    *   Expose the GET endpoint `/api/products/search-and-log`.  
        **宣告端點**：暴露 GET `/api/products/search-and-log` 接口。
    *   Bind incoming query parameters (`q` - required, `minPrice` - optional, `sortBy` - optional with default value `"price"`).  
        **綁定參數**：映射 Query Parameters（`q` 為必填，`minPrice` 與 `sortBy` 為選填）。
    *   Delegate execution to the service.  
        **委派呼叫**：呼叫 Service 層處理業務邏輯並返回結果。

---

## 🚀 How to Run & Verify / 如何啟動與驗證

1.  **Start the Application / 啟動系統**:
    *   Run the main method in `com.example.interview.InterviewApplication` using your IDE (IntelliJ IDEA / Eclipse) or run `mvn spring-boot:run` in terminal.  
        使用 IDE 執行 `InterviewApplication` 的 `main` 方法，或在終端機執行 `mvn spring-boot:run`。
2.  **Test the Endpoint / 測試 API**:
    *   Send a request via curl or your browser:  
        透過 curl 或瀏覽器發送測試請求：
        ```bash
        curl -i "http://localhost:8080/api/products/search-and-log?q=apple&minPrice=100&sortBy=price"
        ```
3.  **Inspect Database Logs (Optional) / 檢查資料庫紀錄（選填）**:
    *   Access the H2 Web Console at `http://localhost:8080/h2-console`.  
        存取 H2 控制台：`http://localhost:8080/h2-console`
    *   JDBC URL: `jdbc:h2:mem:interviewdb`
    *   Username: `sa`
    *   Password: *Leave blank / 留空*
    *   Run `SELECT * FROM SEARCH_QUERY_LOG` to check if query logs are saved correctly.  
        執行 SQL `SELECT * FROM SEARCH_QUERY_LOG` 確認搜尋紀錄是否正確寫入。
