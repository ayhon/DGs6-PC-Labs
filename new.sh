#!/usr/bin/env sh
GASPAR_USERNAME="flealsan"
URL="git@gitlab.epfl.ch:lamp/student-repositories-s22/cs206-$GASPAR_USERNAME.git"
usage(){
	echo -e "Usage:\n\t$0 lab-name num"
}
[ -n "$1" ] && [ -n "$2" ] \
	&& git clone -b $1 $URL $2-$1 \
	|| usage

