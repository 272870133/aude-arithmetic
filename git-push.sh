#!/bin/sh
#echo -e "Are you nex? \c"
#read answer
#echo "$answer is right!"

echo -e "type commit words please"
read answer
commitments="$answer"
echo "let's keep coding!"

git add .
git commit -m "$commitments"
git push -u origin master