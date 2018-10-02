#!/bin/bash

set -e

function createEuler() {
    cd $1
    echo "public class $1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(\"Program took \" 
            + (System.currentTimeMillis() - start) + \"ms\");
    }
}"
}

function executeEuler() {
    cd $1
    javac $1.java && java $1
}

while [[ $# -gt 0 ]]
do
    keys="$1"
    case $keys in
        -c)
        createEuler Euler$2
        shift
        shift
        ;;
        -e) 
        executeEuler Euler$2
        shift
        shift
        ;;
        *)
        shift
        ;;
    esac
done