# Assignment 2: Factory Method and Abstract Factory

**Student:** Berdibek Meiirbek  
**Group:** SE-2528  
**Course:** ShP-2216 Software Design Patterns, Astana IT University  
**Repository:** https://github.com/Mikosh001/Assignment_2_Factory_Method_Abstract_Factory

## Purpose

One Java console application combines Factory Method for road or sea delivery
with Abstract Factory for a matching Windows or macOS button and checkbox.
Both choices are independent. All four combinations run on the same computer.

## Package structure

```text
src/
  app/              Main and DeliveryApplication
  factorymethod/    Transport, Truck, Ship, Logistics,
                    RoadLogistics and SeaLogistics
  abstractfactory/  Button, Checkbox, GUIFactory,
                    WindowsButton, WindowsCheckbox, WindowsFactory,
                    MacOSButton, MacOSCheckbox and MacOSFactory
uml/                Two UML class diagrams: editable .puml and rendered .svg
sources.txt         Java source list used by javac
```

## Prerequisites

Install JDK 17 and put its `bin` directory on `PATH`. A JRE alone is insufficient.
No external libraries, build tools or operating-system-specific UI are needed.

## Build and run

Open a terminal in the repository root. The following commands work in
PowerShell, Command Prompt, Bash and Zsh. Keep the quotes around `@sources.txt`.

```text
java -version
javac -version
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out app.Main ROAD WINDOWS
```

The first two commands must identify Java 17. The compiler creates `out`.
Run all supported combinations without changing or rebuilding the code:

```text
java -cp out app.Main ROAD WINDOWS
java -cp out app.Main SEA WINDOWS
java -cp out app.Main ROAD MACOS
java -cp out app.Main SEA MACOS
```

## Input and validation

Supply exactly two case-sensitive arguments, in this order:

1. Delivery mode: `ROAD` or `SEA`.
2. UI platform: `WINDOWS` or `MACOS`.

The sample cargo is `laboratory equipment`; its destination is `Aktau warehouse`.
These fixed values are passed from `Main` through the application and logistics
workflow to the selected transport.

Missing or extra arguments print an error and usage message. Unsupported values,
including lowercase or empty values, print an error naming the invalid choice
and the allowed values. The program returns from `main` without a stack trace,
default selection, UI construction or delivery. A normal return uses exit code 0;
the validation message identifies rejection.

```text
java -cp out app.Main AIR WINDOWS
java -cp out app.Main ROAD LINUX
java -cp out app.Main
java -cp out app.Main ROAD
```

## Sample run

```text
> java -cp out app.Main ROAD WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road
```

## Design and UML

`Logistics.planDelivery` calls the overridden `createTransport`, then invokes
`Transport.deliver`. `RoadLogistics` creates `Truck`; `SeaLogistics` creates `Ship`.
`DeliveryApplication` receives a `GUIFactory` and `Logistics` in its constructor.
The factory supplies both interface-typed components. The application paints
them and invokes the shared delivery workflow. Only `Main` selects concrete
creators and factories; the client contains no platform or transport branches.

- [Factory Method diagram](uml/factory-method.svg) ([source](uml/factory-method.puml))
- [Abstract Factory diagram](uml/abstract-factory.svg) ([source](uml/abstract-factory.puml))

The report records the tested source commit, all six required checks and
missing-input checks. Git history records the implementation stages.
Compilation and execution were verified on Windows with Eclipse Temurin
JDK 17.0.20.1. All six required checks and both missing-input checks passed.

## References

- Assignment 2 instructions, Astana IT University, 2026-2027.
- Refactoring.Guru: [Factory Method](https://refactoring.guru/design-patterns/factory-method)
  and [Abstract Factory](https://refactoring.guru/design-patterns/abstract-factory).
- Robert C. Martin, *Clean Code*, first edition, Chapter 6, Objects and Data Structures.
- OpenAI Codex: assistance with implementation, explanations and verification.
