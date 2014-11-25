#!/bin/bash

SRC_DIR=/home/shell/git/all/all/game.server/proto
DST_DIR=/home/shell/git/all/all/game.server/src/main/java
protoc -I${SRC_DIR} --java_out=${DST_DIR} ${SRC_DIR}/role.proto
