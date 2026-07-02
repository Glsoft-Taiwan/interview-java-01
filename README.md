# Java Backend Coding Challenge: Product Filter, Aggregator & Logger API

Welcome to the live coding interview. This repository is intended to reduce setup time, so the challenge can focus on implementation rather than local environment troubleshooting.

歡迎來到上機實作面試。本專案的目標是降低環境設定成本，讓測驗重點放在實作，而不是本機環境排錯。

---

## 🔗 Challenge Specification / 測驗詳細規格
The detailed specification, expected JSON response formats, and evaluation criteria are available on the wiki page:  
詳細的 API 規格、預期 JSON 響應格式及評分標準請參閱 Wiki 頁面：

👉 **[Java Backend Coding Challenge Specification (Wiki Link)](https://wiki.david888.com/share/7d186b781ebbfc22ff79614ea049ab66)**

---

## ✅ Environment Options / 執行環境選項
Choose one of the following:

請從以下兩種方式擇一執行：

- **Option A: Local JDK 17 / 本機執行**
  - Requires **Java 17**.
  - Uses the included Maven Wrapper (`./mvnw`), so a separate Maven installation is **not required**.

- **Option B: Docker / 容器執行**
  - Only requires Docker.
  - No local Java or Maven setup is needed.

> Note: This project is configured and tested against **Java 17**.  
> 注意：本專案以 **Java 17** 為基準，請不要假設較新的 JDK 版本一定相容。

---

## 📁 Repository Overview / 專案結構概覽
The starter project already includes:

以下基礎設置已為您準備妥當：

- **Environment**: Spring Boot 3.3.x with Java 17 and in-memory H2 Database configuration.  
  **環境配置**：Spring Boot 3.3.x、Java 17 與 H2 記憶體資料庫配置。
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

### Option A: Run Locally with Java 17 / 使用 Java 17 本機執行

1. Confirm `java -version` shows **Java 17**.  
   請先確認 `java -version` 顯示的是 **Java 17**。
2. Start the app:
   ```bash
   ./mvnw spring-boot:run
   ```
   The first run may download Maven automatically.
   第一次執行時可能會自動下載 Maven。
3. Test the endpoint:
   ```bash
   curl -i "http://localhost:8080/api/products/search-and-log?q=apple&minPrice=100&sortBy=price"
   ```

### Option B: Run with Docker / 使用 Docker 執行

1. Build the image:
   ```bash
   docker build -t interview-java-challenge .
   ```
2. Start the container:
   ```bash
   docker run --rm -p 8080:8080 interview-java-challenge
   ```
3. Test the endpoint:
   ```bash
   curl -i "http://localhost:8080/api/products/search-and-log?q=apple&minPrice=100&sortBy=price"
   ```

### Optional: Inspect Database Logs / 選擇性檢查資料庫紀錄

- Access the H2 Web Console at `http://localhost:8080/h2-console`.  
  存取 H2 控制台：`http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:interviewdb`
- Username: `sa`
- Password: *Leave blank / 留空*
- Run `SELECT * FROM SEARCH_QUERY_LOG` to verify logs were saved correctly.  
  執行 SQL `SELECT * FROM SEARCH_QUERY_LOG` 確認搜尋紀錄是否正確寫入。
