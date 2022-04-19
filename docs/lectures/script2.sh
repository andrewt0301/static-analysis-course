# Creates MD for lectures

for i in {1..9}
do
   echo "$i. [Lecture $i](lectures/0$i/index.md)"
   echo ""
done

for i in {10..15}
do
   echo "$i. [Lecture $i](lectures/$i/index.md)"
   echo ""
done
