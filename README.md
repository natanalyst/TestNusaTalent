# Katalon API Testing - OpenWeatherMap

Project ini adalah implementasi automated API testing menggunakan **Katalon Studio** untuk memverifikasi data cuaca dan polusi udara dari **OpenWeatherMap API**, dengan fokus pada area **Jakarta**.

---

## 🔧 Scenarios Diuji

### 1. 5-Day Weather Forecast - Jakarta Selatan
- Endpoint: `/data/2.5/forecast`
- Validasi:
  - Status code `200`
  - JSON body (`city.name`)
  - JSON Schema

### 2. Current Air Pollution - Jakarta Selatan
- Endpoint: `/data/2.5/air_pollution`
- Validasi:
  - Status code `200`
  - `coord.lon`, `coord.lat` nilai sesuai
  - JSON Schema

---

##  Struktur Project
Test Cases/
├── TC - 0001 - Verify API Forecast
├── TC - 0002 - Verify API air pollution

Object Repository/
├── forecast/
└── air pollution/

Test Suites/
├── TS - 0001 - Verify API Forecast
└── TS - 0002 - Verify API air pollution


---

## Cara Menjalankan Test

### 1. Buka Project di Katalon Studio

### 2. Jalankan Test Suite
Pilih test suite:
- `TS - 0001 - Verify API Forecast`
- `TS - 0002 - Verify API air pollution`

Klik tombol **Run**.

### 3. Lihat Report
Laporan otomatis tersimpan di:
Reports/
└── <timestamp>/
└── TS - 000X.html

