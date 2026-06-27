## Opis projektu
HomeHub to prosta aplikacja do zarządzania urządzeniami smart w domu. Umożliwia rejestrację urządzeń, wyszukiwanie oraz sortowanie według różnych kryteriów.

## Funkcjonalności
- Dodawanie urządzeń (`registerDevice`)
- Sprawdzanie duplikatów (id / macAddress)
- Pobieranie urządzeń według pomieszczenia
- Sortowanie urządzeń (naturalny porządek: name → room)

## Struktura projektu
- `SmartDevice` – klasa reprezentująca urządzenie
- `HomeHub` – klasa zarządzająca urządzeniami
- `DuplicateDeviceException` – wyjątek dla duplikatów

## Jak uruchomić
1. Otwórz projekt w IntelliJ / Eclipse
2. Uruchom klasę `Main`
3. Testuj metody w kodzie

## Wymagania
- Java 8+ (lub 17 jeśli używasz streamów z `toList()`)
