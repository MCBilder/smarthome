# HomeHub

## Opis projektu

HomeHub to prosta aplikacja do zarządzania urządzeniami smart w domu. Umożliwia rejestrację urządzeń, wyszukiwanie oraz sortowanie według różnych kryteriów. Projekt został rozbudowany o kilka wzorców projektowych pozwalających na łatwiejszą integrację nowych urządzeń oraz rozszerzanie funkcjonalności systemu.

Dodatkowo aplikacja obsługuje komunikację pomiędzy czujnikami i centralą, elastyczne strategie sterowania ogrzewaniem, inteligentne rolety działające w oparciu o maszynę stanów oraz generowanie raportów diagnostycznych dla wszystkich urządzeń.

---

## Funkcjonalności

* Dodawanie urządzeń (`registerDevice`)
* Sprawdzanie duplikatów (`id` / `macAddress`)
* Walidacja adresów MAC
* Pobieranie urządzeń według pomieszczenia
* Sortowanie urządzeń (naturalny porządek: `name → room`)
* Włączanie i wyłączanie urządzeń
* Odczyt statusu urządzeń
* Obsługa starszych urządzeń za pomocą wzorca **Adapter**
* Dynamiczne rozszerzanie funkcjonalności urządzeń za pomocą wzorca **Decorator**
* Gotowe scenariusze działania domu przy użyciu wzorca **Facade**
* Powiadamianie centrali o zdarzeniach z czujników ruchu
* Dynamiczna zmiana strategii ogrzewania
* Obsługa inteligentnych rolet z wykorzystaniem maszyny stanów
* Generowanie raportów diagnostycznych dla wszystkich urządzeń

---

## Wykorzystane wzorce projektowe

* **Factory Method** – tworzenie urządzeń
* **Adapter** – integracja klasy `LegacyThermostat` z systemem
* **Decorator** – dodawanie monitorowania energii bez modyfikacji urządzeń
* **Facade** – uproszczone sterowanie całym systemem domu
* **Observer** – komunikacja pomiędzy czujnikami a centralą HomeHub
* **Strategy** – możliwość zmiany sposobu sterowania temperaturą w czasie działania programu
* **State** – zarządzanie stanami inteligentnych rolet
* **Visitor** – generowanie raportów diagnostycznych bez modyfikowania klas urządzeń

---

## Struktura projektu

```text
src/
├── blind/
│   ├── BlindState.java                – interfejs stanów inteligentnych rolet
│   ├── ClosedState.java               – stan zamkniętej rolety
│   ├── OpenedState.java               – stan otwartej rolety
│   ├── MovingState.java               – stan rolety będącej w ruchu
│   └── SmartBlind.java                – inteligentne rolety wykorzystujące wzorzec State
│
├── device/
│   ├── ManageableDevice.java          – interfejs wspólny dla wszystkich urządzeń
│   ├── SmartDevice.java               – bazowa klasa urządzenia
│   ├── DeviceFactory.java             – tworzenie urządzeń (Factory Method)
│   ├── DeviceDecorator.java           – bazowy dekorator urządzeń
│   ├── EnergyMonitoringDecorator.java – dekorator monitorujący zużycie energii
│   ├── DeviceVisitor.java             – interfejs odwiedzającego urządzenia
│   └── DiagnosticsVisitor.java        – generowanie raportów diagnostycznych
│
├── exception/
│   ├── InvalidMacAddressException.java – wyjątek dla niepoprawnego adresu MAC
│   └── DuplicateDeviceException.java   – wyjątek dla zduplikowanych urządzeń
│
├── HomeHub/
│   ├── HomeHub.java                   – centrala zarządzająca urządzeniami oraz odbierająca zdarzenia z czujników
│   └── SmartHomeFacade.java           – uproszczony interfejs sterowania całym domem
│
├── sensor/
│   ├── SensorObserver.java            – interfejs obserwatora zdarzeń z czujników
│   └── MotionSensor.java              – czujnik ruchu powiadamiający obserwatorów
│
├── thermostat/
│   ├── LegacyThermostat.java          – starszy model termostatu
│   ├── ThermostatAdapter.java         – adapter integrujący stary termostat z systemem
│   ├── HeatingStrategy.java           – interfejs strategii sterowania temperaturą
│   ├── EcoStrategy.java               – energooszczędna strategia ogrzewania
│   └── ComfortStrategy.java           – strategia utrzymująca komfortową temperaturę
│
└── Main.java                          – klasa uruchamiająca aplikację
```

---

## Przykładowe scenariusze

* `movieMode()` – wyłącza główne światła i uruchamia telewizor
* `goodNightRoutine()` – wyłącza urządzenia i aktywuje tryb nocny
* Monitorowanie uruchomień urządzeń przez dekorator energii
* Wykrycie ruchu przez `MotionSensor` powoduje wysłanie powiadomienia do `HomeHub` i wyświetlenie komunikatu alarmowego
* Dynamiczna zmiana strategii ogrzewania pomiędzy `EcoStrategy` i `ComfortStrategy`
* Sterowanie inteligentnymi roletami z uwzględnieniem ich aktualnego stanu
* Uruchomienie diagnostyki wszystkich urządzeń za pomocą metody `runDiagnostics()`

---

## Jak uruchomić

1. Otwórz projekt w IntelliJ IDEA lub Eclipse.
2. Uruchom klasę `Main`.
3. Dodaj urządzenia do `HomeHub`.
4. Przetestuj działanie wzorców **Factory Method**, **Adapter**, **Decorator** oraz **Facade**.
5. Sprawdź komunikację pomiędzy `MotionSensor` i `HomeHub`.
6. Przetestuj zmianę strategii ogrzewania (`EcoStrategy` / `ComfortStrategy`).
7. Sprawdź działanie inteligentnych rolet opartych na wzorcu **State**.
8. Uruchom diagnostykę urządzeń przy użyciu `DiagnosticsVisitor`.

---

## Wymagania

* Java 8+ (zalecana Java 17)
* IntelliJ IDEA / Eclipse
