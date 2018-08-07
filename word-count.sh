#!/usr/bin/env bash

# Purpose:  outputs the word frequency count in a text file
cat $1 | sed 's|[,.]||g' | tr ' ' '\n' | sort | uniq -c

