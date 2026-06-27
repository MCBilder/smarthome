# HomeHub

## Opis projektu
HomeHub to prosta aplikacja do zarządzania urządzeniami smart w domu. Umożliwia rejestrację urządzeń, wyszukiwanie oraz sortowanie według różnych kryteriów.

HomeHub to prosta aplikacja do zarządzania urządzeniami smart w domu. Umożliwia rejestrację urządzeń, wyszukiwanie oraz sortowanie według różnych kryteriów. Projekt został rozbudowany o kilka wzorców projektowych pozwalających na łatwiejszą integrację nowych urządzeń oraz rozszerzanie funkcjonalności systemu.

## Funkcjonalności
- Dodawanie urządzeń (`registerDevice`)
- Sprawdzanie duplikatów (id / macAddress)
- Pobieranie urządzeń według pomieszczenia
- Sortowanie urządzeń (naturalny porządek: name → room)

* Dodawanie urządzeń (`registerDevice`)
* Sprawdzanie duplikatów (id / macAddress)
* Pobieranie urządzeń według pomieszczenia
* Sortowanie urządzeń (naturalny porządek: name → room)
* Włączanie i wyłączanie urządzeń
* Odczyt statusu urządzeń
* Obsługa starszych urządzeń za pomocą wzorca Adapter
* Dynamiczne rozszerzanie funkcjonalności urządzeń za pomocą wzorca Decorator
* Gotowe scenariusze działania domu przy użyciu wzorca Facade

## Wykorzystane wzorce projektowe

* **Factory Method** – tworzenie urządzeń
* **Adapter** – integracja klasy `LegacyThermostat` z systemem
* **Decorator** – dodawanie monitorowania energii bez modyfikacji urządzeń
* **Facade** – uproszczone sterowanie całym systemem domu

## Struktura projektu
- `SmartDevice` – klasa reprezentująca urządzenie
- `HomeHub` – klasa zarządzająca urządzeniami
- `DuplicateDeviceException` – wyjątek dla duplikatów

* `ManageableDevice` – interfejs wspólny dla wszystkich zarządzalnych urządzeń
* `SmartDevice` – bazowa klasa urządzenia
* `HomeHub` – centrala zarządzająca urządzeniami
* `LegacyThermostat` – stary termostat z własnym API
* `ThermostatAdapter` – adapter dla starego termostatu
* `DeviceDecorator` – bazowy dekorator urządzeń
* `EnergyMonitoringDecorator` – dekorator monitorujący uruchomienia urządzeń
* `SmartHomeFacade` – uproszczony interfejs do obsługi domu
* `DuplicateDeviceException` – wyjątek dla duplikatów

## Przykładowe scenariusze

* `movieMode()` – wyłącza główne światła i uruchamia telewizor
* `goodNightRoutine()` – wyłącza urządzenia i aktywuje tryb nocny
* Monitorowanie czasu uruchomienia urządzeń przez dekorator energii

## Jak uruchomić

1. Otwórz projekt w IntelliJ / Eclipse
2. Uruchom klasę `Main`
3. Testuj metody w kodzie
3. Dodaj urządzenia do `HomeHub`
4. Przetestuj działanie Adaptera, Decoratora i Fasady

## Wymagania
- Java 8+ (lub 17 jeśli używasz streamów z `toList()`)

* Java 8+ (lub Java 17)
* IntelliJ IDEA / Eclipse
