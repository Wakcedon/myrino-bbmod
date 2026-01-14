# Myrino Mod (Fabric 1.21.1 Template)

Шаблон для быстрого старта разработки мода под Minecraft 1.21.1 (Fabric).

## Быстрый старт

1. Откройте проект в любимой IDE (IntelliJ IDEA, Eclipse и т.д.).
2. Выполните `./gradlew genSources` (Linux/macOS) или `gradlew genSources` (Windows) для генерации исходников.
3. Соберите мод:  
   ```
   ./gradlew build
   ```
   Собранный `.jar` лежит в `build/libs/`.

4. Скопируйте jar в папку mods вашего клиента Minecraft (с Fabric Loader 1.21.1).

## Изменение namespace/имени мода

- Замените значения в `fabric.mod.json` и пакетах Java, если нужно.

## Основные ссылки

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Architectury Template](https://github.com/architectury/architectury-template)