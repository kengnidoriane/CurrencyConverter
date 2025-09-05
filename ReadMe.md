# 💱 Currency Converter API

This is a simple Spring Boot REST API that converts currency amounts using real-time exchange rates from an external API.

---

## 🚀 Features

* Convert currencies using real-time data
* Swagger UI for API documentation
* Exception handling with clear error messages
* Clean code and separation of concerns
* Externalized configuration for easy environment setup

---

## 🧰 Technologies Used

* Java 21
* Spring Boot 3.5
* Spring Web
* RestTemplate
* Swagger (Springdoc OpenAPI)
* Maven

---

## 📦 Installation & Setup

### 1. **Clone the Repository**

```bash
git clone https://github.com/kengnidoriane/CurrencyConverter.git
cd CurrencyConverter
```

---

### 2. **Configure the API Key**

To connect to the external exchange rate API, follow these steps:

1. **Locate the configuration file:**

   Open the file located at:

   ```
   src/main/resources/application.properties
   ```

2. **View and edit the following properties inside the file:**

   ```properties
   exchange.api.base-url=https://api.apilayer.com/exchangerates_data
   exchange.api.key=your_api_key
   ```

3. **Create an account on the API provider’s website:**

   Go to [https://apilayer.com](https://apilayer.com) and sign up for a free or paid account.

4. **Copy your API key:**

   After creating your account, your personal API key will be displayed on your dashboard.

5. **Replace the placeholder in the file:**

   Replace `your_api_key` in `application.properties` with the key you just copied.
   For example:

   ```properties
   exchange.api.key=mDB0lSzIoj9gRhjk34kjEFsUq6kAGPcn
   ```

> ✅ This step is required for the application to successfully connect to the real-time currency exchange API.

---

### 3. **Build the Project**

Make sure Maven is installed and run:

```bash
./mvnw clean install
```

### 4. **Run the Application**

```bash
./mvnw spring-boot:run
```

Or using IntelliJ: Run `CurrencyConverterApplication.java`.

---

## 📡 API Documentation (Swagger UI)

Once the app is running, open:

```
http://localhost:8080/swagger-ui.html
```

You’ll find detailed documentation and a way to test endpoints via the browser.

---

## 📬 Example Request

```http
POST /api/convert
Content-Type: application/json

{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```

**Response:**

```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 92.5
}
```

---

## 🛠 Project Structure

```
com.currency.converter
├── client            # Calls to external API
├── controller        # REST endpoints
├── dto               # Request/response payloads
├── exception         # Custom exceptions and handlers
├── service           # Business logic
└── CurrencyConverterApplication.java
```


