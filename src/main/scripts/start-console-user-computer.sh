#!/usr/bin/env sh
# Fix current dir issue for MacOS. Read more: http://hints.macworld.com/article.php?story=20041217111834902
cd "$(dirname "$0")" || exit
# ----------------------------------------------------------------------------------------------------------------------
./start.sh console user computer