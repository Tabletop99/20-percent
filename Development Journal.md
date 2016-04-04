##### 04.03.16
I investigated further into how swing timers work this week, and fortunately it worked much better than the general-purpose timer. Using a swing timer, my project can now successfully track the user's words per minute by comparing the user's input to the target text, finding how many words are correct, multiplying the correct number of words by 60 and then dividing by the number of seconds that have passed. This means that my second deliverable is completed. I also fixed a bug where backspacing with no input would cause a crash due to an out of bounds exception. Next week I will have to figure out what text to use as the target text for the user to type (so far I have just been using a single sentence to test). I will also have to find a way to put all of the target text in the GUI so it is easily readable by the user.

##### 03.20.16
I began working on the timer for my project last week (03.13.16), and I created a simple timer that I assumed I could modify and add on to in order to fit my needs. However, this timer has not been working out well because it will not run while the user is typing. It either refuses to run or prevents the user from typing. I did some research to try and solve this problem and I discovered that there are two different kinds of timers in java. The one I was using is a general-purpose timer, and the other is called a swing timer. The swing timer works much better than the general-purpose timer when dealing with a GUI, so it seems to be a much better fit for my project. When I come back to this project after spring break I will look into how to use a swing timer and see if it works for what I am tring to do.

##### 02.28.16
Today and Friday I made my project much easier to use. I added the backspace functionality, which was much easier to do than I thought it would be since I am not implementing the arrow keys. I also made the project check the user's input word-by-word instead of all at once, which makes it only color the word that is wrong red instead of the entire thing. Next week i will begin looking into how to create a timer so I can be ready for the next deliverable.

##### 02.21.16
I began writing my code Friday, and I completed my first deliverable today. I now have a program that compares the typed input text to the target text and if they do not match it turns the input text red. Unfortunately, backspacing has not been implemented and so messing up one character turns everything red and the only way to make it black again is to restart. The next thing I will do is make the program compare the two texts word by word so that if a word is wrong it will only turn that word red instead of the entire thing. I'll do this by using the split method that we used in the EOC project to process commands.

##### 02.14.16
I spent today examining project 7 to learn how to create a class with a key listener and also to learn a bit about how a GUI works. I have labeled the parts of project 7 that I didn't understand previously with what they do. I should be able to begin writing my code next week.

##### 02.05.16
Today I looked into how to create a class in java that can respond to keystrokes. I disovered that I need to use a key listener to do this. I found an example online that I can use to help me write my own key listener, and I can also look back at project 7 for another reference.
