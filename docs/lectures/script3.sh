# Generates templates for lectures

print () {
  F="$1/index.md"
  echo "# Topic $1" >> $F
  echo '' >> $F
  echo '## Lecture' >> $F
  echo '' >> $F
  echo "Slides: [PDF](slides_$1.pdf), [PPTX](slides_$1.pptx)" >> $F
  echo '' >> $F
  echo "Notes: [PDF](nodes_$1.pdf)" >> $F
  echo '' >> $F
  echo '#### Outline' >> $F
  echo '' >> $F
  echo '* TODO' >> $F
  echo '' >> $F
  echo '## References' >> $F
  echo '' >> $F
  echo '* TODO' >> $F
  echo '' >> $F
}

for i in {1..9}
do
   print "0$i"
done

for i in {10..15}
do
   print "$i"
done
