# plastic-jetbrains

**This theme is no longer maintained.**

![Build](https://github.com/barfurth/plastic-jetbrains/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/18166-plastic.svg)](https://plugins.jetbrains.com/plugin/18166-plastic)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/18166-plastic.svg)](https://plugins.jetbrains.com/plugin/18166-plastic)

<!-- Plugin description -->
This is a port of the [Plastic theme](https://plastictheme.com/) by [Will Stone](https://wstone.io/) adapted for
Jetbrains IDEs. In order to set some colors a custom annotator was implemented. This allows separate highlighting of
some things Jetbrains Platform IDEs do not usually allow highlighting of. The custom annotator requires a specific
implementation per language in order to define which keywords are to be highlighted in what colors. The goal is to
be closer to the semantic highlighting used by VS Code.
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "plastic-jetbrains"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/barfurth/plastic-jetbrains/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
