# cat wordcount.input | python mapperTest.py | python reducerTest.py | sort -k 2r
import sys
for line in sys.stdin:#隐含readline
    ls = line.split()
    for word in ls:
        if len(word.strip()) != 0:
            print(word + ',' + str(1))
