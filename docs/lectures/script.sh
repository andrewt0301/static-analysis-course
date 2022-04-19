# Creates folders for lectures

SEP=$'---'

for i in {1..9}
do
   mkdir "0$i"
   L="Lecture $i"
   echo "$L" >> "0$i/index.md"
   echo "$SEP" >> "0$i/index.md"
done

for i in {10..15}
do
   mkdir "$i"
   L="Lecture $i"
   echo "$L" >> "$i/index.md"
   echo "$SEP" >> "$i/index.md"
done
