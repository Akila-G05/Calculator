# Calculator

A desktop calculator application written in Java, built with Apache Ant in NetBeans.

## Features

- Basic arithmetic — addition, subtraction, multiplication, division
- Percentage (`%`) and square root (`√`) operations
- `C` to clear and `<--` to delete the last digit
- Clipboard support — **Copy** and **Cut** from the Edit menu
- **New Window** from the View menu to open multiple calculator instances
- Menu bar with View / Edit / Theme options

## Project Structure

```
Calculator/
├── src/
│   ├── Calculator.java   # Entry point + calculator window & logic (AWT)
│   └── NewJFrame.java    # Empty NetBeans-generated Swing form
├── lib/                  # Third-party libraries
├── nbproject/            # NetBeans project configuration
├── test/                 # Test sources
└── build.xml             # Apache Ant build script
```

## Technologies

| Technology | Purpose |
|---|---|
| Java SE 8 | Core application language |
| Java AWT | Desktop UI (Frame, Panel, GridLayout, MenuBar) |
| Apache Ant | Build system (NetBeans project) |
| Java Swing | Used by the `NewJFrame` form |

## Getting Started

### Prerequisites

- JDK 8 or later
- NetBeans (recommended, for opening the project)

### Build & Run

```sh
ant clean jar
java -jar dist/Calculator.jar
```

Or open the project in NetBeans and press **F6** to run.
## License

MIT � see [LICENSE](LICENSE).
