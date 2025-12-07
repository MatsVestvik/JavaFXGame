# JavaFXGame

This project is configured as a Maven project with JavaFX using the `javafx-maven-plugin`.

## Quick start (PowerShell)

Compile:

```powershell
mvn compile
```

Run the JavaFX application (uses `com.example.game.GameMain`):

```powershell
mvn javafx:run
```

If you prefer to run the `Main` launcher class directly, you can run:

```powershell
mvn exec:java -Dexec.mainClass="Main"
```

(But `mvn javafx:run` is recommended because it configures the JavaFX module-path automatically.)

## Running from an IDE

- IntelliJ: Import the project as a Maven project. Run the Maven goal `javafx:run` (via the Maven tool window) or set VM options to include JavaFX library path, for example:

```
--module-path "C:\\path\\to\\javafx-sdk-25\\lib" --add-modules javafx.controls,javafx.fxml
```

- VS Code: Use the Maven extension or run the Maven goal `javafx:run` from the terminal.

## Notes

- `pom.xml` sets Java version and includes the JavaFX dependency with a Windows classifier.
- The plugin is configured to pass `--enable-native-access=javafx.graphics` so JavaFX native loading works on recent JDKs.

If you want a runnable fat JAR or IDE-runner shortcuts added, tell me which you prefer and I will add it.
# JavaFXGame