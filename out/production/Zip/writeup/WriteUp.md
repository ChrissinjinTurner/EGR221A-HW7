# Project 1 (Zip) Write-Up #
--------

#### How Was Your Partnership? ####
-   Did both partners do an equal amount of work?  If not, why not?
    What happened?<pre>
Yes, we both worked the same amount on this assignment. 
</pre><br>

-----

#### Project Enjoyment ####
-   What was your favorite part of the project?  What was your least
    favorite part of the project?<pre>
Favorite part was working together on a project, least favorite was working with the tries. 
</pre><br>

-   Did you enjoy the project?<pre>
It wasnt terrible, could have been better though. 
</pre><br>

-----

#### WorkLists, Tries, and Zip ####
-   The ADT for a WorkList explicitly forbids access to the middle elements.  However, the FixedSizeFIFOWorkList has a peek(i) method
    which allows you to do exactly that.  Why is this an acceptable addition to the WorkList ADT in this particular case but not in general?<pre>
This peek method allows an element to be replaced at the value of (i). This is acceptable in our case because the WorList is FIFO, which creates a well
defined order within the data structure. In any other case, providing users access to the middle of the structure may dissolve order within the structure.
</pre><br>
-   As we've described it, a `TrieMap` seems like a general-purpose replacement for `HashMap` or `TreeMap`.  Why might we still want to use one
    of these other data structures instead?<pre>
Hashmaps and treemaps are more generic working on any object, where as triemaps only work on sequenced objects. 
</pre><br>
-   One of the applications of Tries is in solving Word Searches.  A "word search" is an n x m rectangle of letters.  The goal is to find all
    of the possible words (horizontal, vertical, diagonal, etc.).  In Boggle, a similar game, any consecutive chain of letters (even repetitions)
    are allowed.  Explain (in very high-level psuedo-code) how you might solve this problem with a TrieSet or a TrieMap.  Make sure to detail
    how a similar solution that uses a HashSet/HashMap instead would be different and why using a Trie might make the solution better.<pre>
public trie findWord(String s) {
    this word;
    for (int i = 0; i < s.length; i++) {
        getChar at index;
        get its children;
        if (child is null) {
            return null; theres no child (word)
        }
        current node = child;
    }
    return current node;
}
Trie are better due to their nature to only store single letters instead of full elements, like a map or set would do. In this case, since you are creating
words one letter at a time the trie is a much better choice. It accounts for all possibilities when testing words. 
</pre><br>
-   One of the classes in the egr221a.main package is called Zip.  This class uses your PriorityQueue to do Huffman coding, your FIFOQueue as a buffer,
    your stack to calculate the keyset of a trie (using recursive backtracking), and your SuffixTrie to do LZ77Compression.  Find some text file
    (a free book from https://www.gutenberg.org/ or even the HTML of some website) and use Zip.java to zip it into a zip file.  Then, use a 
    standard zip utility on your machine (Finder on OS X, zip on Linux, WinZip or the like on Windows) to UNZIP your file.  Check that you got back
    the original.  Congratulations!  Your program correctly implements the same compression algorithm you have been using for years!  Discuss in a
    sentence or two how good the compression was and why you think it was good or bad.<pre>
We had a compression rate of about 40%, we were able to reduce the 12.2mb file to a size of 7.3mb. On much much larger files this is a sifnificant 
change. Even on this file it provided a large change. 
</pre><br>
-   Now that you've played with Zip, we want you to do an **experiment** with Zip.  Notice that there is a constant called `BUFFER_LENGTH` in `Zip.java`.
    Higher values of this constant makes the compression algorithm that Zip uses use more memory and consequently more time.  The "compression ratio"
    of a file is the uncompressed size divided by the compressed size.  Compare time, space, type of input file, and compression ratio by running
    your code on various inputs.  We would like an in-depth analysis.  You should try at least one "book-like" file, at least one "website-like" file,
    and some other input of your choice.  We expect you to draw meaningful conclusions and possibly have graphs that convince us of your conclusions.
    This single question is worth almost as much as the implementation of `ArrayStack`; so, please take it seriously.  If you spend less than 20 minutes
    on this question, there is no conceivable way that you answered this question in the way we were intending.<pre>
In our original test, we ran the ZIP algorithm against a 12mb .txt file.  The compression took 28 minutes and compressed the size of the file to 7.3mb.  
This is a compression ratio of 1.64, or a compression to 60.83% of original size. According to HowToGeek, the compression of Windows 8.1 exhibits a similar 
ratio of compression percentage.  863 MB in size of music, graphics, executable files, and various different types of documents in Zip (Windows 8.1): 746 MB 
(86.4% of the original size). Also, 654 MB of data: Zip (Windows 8.1): 316 MB (48.3% of the original size).  To test even further, we tried zipping a html file.  
The html's original size was: 327kb. The compression size was 136kb, giving a ratio 2.4 and percentage of 41%. Although, this may not be entirely accurate as the sizes of the files were extremely different. We also
checked a pdf file. Its original size was , its compressed size was , giving a ration of  and a percentage of. Based on these extensive tests, we conclude that our algorithm 
has an easier time and better compression zipping files of .html type.
</pre><br>

#### Above and Beyond ####
-   Did you do any Above and Beyond?  Describe exactly what you
    implemented.<pre>
No
</pre><br>
