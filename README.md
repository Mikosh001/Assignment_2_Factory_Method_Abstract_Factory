# Assignment 2: Factory Method and Abstract Factory

Berdibek Meiirbek, SE-2528

This Java console application combines road/sea delivery with a matching
Windows/macOS button and checkbox. Factory Method creates the transport;
Abstract Factory creates the UI family.

## Structure

- `src/app` - startup and application client.
- `src/factorymethod` - transport products and logistics creators.
- `src/abstractfactory` - UI products and factories.
- `uml` - PlantUML sources and rendered PNG diagrams.
- `sources.txt` - source files for compilation.

## Build and run

Use **JDK 17**, with `java` and `javac` on `PATH`. No external libraries are needed.
Run these commands from the project root (including the quotes):

```text
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out app.Main ROAD WINDOWS
```

Arguments are case-sensitive: `ROAD` or `SEA`, then `WINDOWS` or `MACOS`.
All four combinations work on one computer. Missing/extra arguments or unsupported
values print a clear error and stop without rendering or delivery (normal exit 0).

Sample output:

```text
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road
```

## UML and verification

- [Factory Method](uml/factory-method.png) / [PlantUML source](uml/factory-method.puml)
- [Abstract Factory](uml/abstract-factory.png) / [PlantUML source](uml/abstract-factory.puml)

All six required checks and missing-input checks passed on JDK 17. The English
report contains the actual results, references and submitted commit ID.
AI assistance: OpenAI Codex helped with code, explanations and verification.
