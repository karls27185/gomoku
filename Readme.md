# The Gomoku Project

-----------------------------------------------------------------------------------

## Without JRE

### Build instructions

- Сборка при помощи maven:

```bash
mvn -P without-jre clean package
```

- Получим следующие архивы
  - `target/gomoku-${project.version}-windows.zip` для Windows
  - `target/gomoku-${project.version}-unix.tar.gz` для MacOS и Linux

### Run instructions

- Скачать [OpenJDK 11](https://jdk.java.net/11/);
- Распаковать OpenJDK;
- Сконфигурировать `PATH` переменную среды;
  - Добавить `%JDK_HOME%\bin\` для Windows;
  - Добавить `$JDK_HOME/bin/` для MacOS и Linux;
- Пере логиниться или перезагрузить компьютер;
- Распаковать архив;
  - `gomoku-${project.version}-windows.zip` для Windows;
  - `gomoku-${project.version}-unix.tar.gz` для MacOS и Linux;
- Перейти в папку с распакованной игрой;
- Запустить игру двойным кликом по скрипту запуска;
  - `start.cmd` для Windows;
  - `start.sh` для MacOS и Linux;

-----------------------------------------------------------------------------------

## With JRE

### Build instructions

- Сборка при помощи maven:

```bash
mvn -P with-jre clean package
```

- Получим следующие архивы
  - `target/gomoku-${project.version}-windows-with-jre.zip` для Windows;
  - `target/gomoku-${project.version}-macos-with-jre.tar.gz` для MacOS;
  - `target/gomoku-${project.version}-linux-with-jre.tar.gz` для Linux;

### Run instructions

- Распаковать архив;
  - Unzip `gomoku-${project.version}-windows-with-jre.zip` для Windows;
  - Unzip `gomoku-${project.version}-macos-with-jre.tar.gz` для MacOS;
  - Unzip `gomoku-${project.version}-linux-with-jre.tar.gz` для Linux;
- Перейти в папку с распакованной игрой;
- Запустить игру двойным кликом по скрипту запуска;
  - `start.cmd` для Windows;
  - `start.sh` для MacOS и Linux;

-----------------------------------------------------------------------------------

## Readme tutorial

- https://guides.github.com/features/mastering-markdown/
- https://help.github.com/categories/writing-on-github/
