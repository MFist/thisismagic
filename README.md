# This Is Magic

A Minecraft Forge mod that adds a comprehensive magic system to the game. Built for Minecraft 1.20.4.

## Features (Planned)

- Magic System Framework
- Magical Items and Blocks
- Spell Casting System
- Rune-based Magic
- Alchemy System

## Development Status

🚧 **Early Development** - Basic framework and structure setup in progress.

## Requirements

- Minecraft 1.20.4
- Forge (Latest)
- Java 17

## Installation

1. Download the latest release from the releases page (coming soon)
2. Place the .jar file in your Minecraft mods folder
3. Launch Minecraft with Forge 1.20.4

## For Developers

### Setup Process

1. Clone the repository:
   ```bash
   git clone https://github.com/MFist/thisismagic.git
   ```

2. Setup your development environment:
   
   **For Eclipse:**
   ```bash
   ./gradlew genEclipseRuns
   ```
   Then import as Existing Gradle Project

   **For IntelliJ IDEA:**
   - Import project as Gradle project
   - Run: `./gradlew genIntellijRuns`

3. Build the mod:
   ```bash
   ./gradlew build
   ```

### Project Structure

```
src/main/
├── java/com/thisismagic/
│   ├── ThisIsMagic.java         # Main mod class
│   ├── magic/                   # Magic system implementation
│   └── registry/                # Registry handlers
└── resources/
    ├── assets/thisismagicmod/   # Textures, models, etc.
    └── data/thisismagicmod/     # Data generation
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.txt) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Credits

- Built with [Minecraft Forge](https://files.minecraftforge.net/)
- Developed by MFist 