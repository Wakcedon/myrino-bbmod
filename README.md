# Myrino - Infinite Tower Survival Mod

## Overview
Myrino is a comprehensive Fabric mod for Minecraft 1.20.1 that adds infinite tower survival gameplay with custom entities, advanced animations, and challenging boss encounters.

## Features

### Custom Entities
- **Tower Mob**: Standard hostile mob with aggressive AI
  - Health: 20
  - Attack Damage: 5
  - Armor: 2

- **Elite Guardian**: Stronger variant with shield mechanics
  - Health: 35
  - Attack Damage: 8
  - Armor: 4
  - Special: Periodic damage reduction shields

- **Tower Boss**: Epic boss entity with phased combat
  - Health: 100
  - Attack Damage: 15 (increases to 20 in phase 2)
  - Armor: 5
  - Boss Bar: Integrated boss health display
  - Multi-phase: Changes behavior and stats on phase transition

### Animation System
- Flexible animation framework with `EntityAnimation` base class
- Built-in `AttackAnimation` for combat sequences
- `AnimationController` for managing multiple animations per entity
- Smooth animation transitions and progress tracking

### Boss Mechanics
- Health-based phase transitions
- Dynamic stat scaling between phases
- Boss bar tracking
- Customizable combat behavior

## Project Structure

```
myrino-bbmod/
├── src/main/java/com/wakcedon/myrino/
│   ├── MyrinoMod.java                  # Main mod entry point
│   ├── MyrinoModClient.java            # Client initialization
│   ├── entity/
│   │   ├── TowerMobEntity.java         # Basic tower mob
│   │   ├── TowerBossEntity.java        # Boss entity with phases
│   │   └── EliteGuardianEntity.java    # Elite variant with shields
│   ├── animation/
│   │   ├── EntityAnimation.java        # Animation base class
│   │   ├── AttackAnimation.java        # Attack animation implementation
│   │   └── AnimationController.java    # Animation management
│   └── client/renderer/
│       ├── TowerMobRenderer.java       # Mob rendering
│       ├── TowerBossRenderer.java      # Boss rendering
│       └── EliteGuardianRenderer.java  # Elite rendering
├── src/main/resources/
│   ├── fabric.mod.json                 # Mod metadata
│   ├── myrino.mixins.json              # Mixin configuration
│   └── assets/myrino/lang/
│       └── en_us.json                  # English translations
├── gradle.properties                    # Gradle configuration
├── build.gradle                         # Build script
└── settings.gradle                      # Gradle settings
```

## Building

Requirements:
- JDK 17 or higher
- Gradle

Build steps:
```bash
./gradlew build
```

Generate IDE files:
```bash
./gradlew genSources
./gradlew idea  # For IntelliJ IDEA
./gradlew eclipse  # For Eclipse
```

## Development

To set up the development environment:
1. Clone the repository
2. Run `./gradlew genSources`
3. Import the project into your IDE
4. Run `./gradlew runClient` to launch a test server with the mod

## Configuration

The mod uses Fabric API for configuration. Future versions will include:
- Entity spawn rates
- Difficulty scaling
- Tower height configuration
- Boss behavior customization

## Future Enhancements

- [ ] Complete BBModel animations for entities
- [ ] Tower generation system
- [ ] Loot tables and drops
- [ ] Sound effects and particles
- [ ] Config GUI
- [ ] Multiplayer synchronization
- [ ] Additional boss types
- [ ] Special ability system

## License

MIT License - See LICENSE file for details

## Author

Wakcedon

## Support

For issues and suggestions, please visit: https://github.com/Wakcedon/myrino-bbmod
