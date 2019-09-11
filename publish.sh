#!/bin/bash

set -e

cd "$(dirname "$0")"

for item in Light Regular Medium Heavy Bold
do
    echo $item
    cd Android-Font-Assets-Alibaba_PuHuiTi_$item
    ./gradlew clean bU
    cd -
done
