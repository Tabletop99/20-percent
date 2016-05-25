
/**
 * Write a description of class TextChooser here.
 * 
 * @author Drew McMains 
 * @version (a version number or a date)
 */
public class TextChooser
{
    private String text0 = "Of all lines of poultry keeping, duck raising is unique in that it lends itself to the greatest degree of specialization and intensification along lines which are purely commercial. On a comparatively small area thousands of ducklings can be reared and marketed yearly. The methods used by successful Long Island duck raisers differ widely in some particulars and in the space at command, it has been impossible to describe all the methods.";
    private String text1 = "It is on this point, on the trammels of individual freedom with which we may almost be said to be born into the world, and on the means by which we may shake off these old chains, that I wish to speak to you this evening. You need not be afraid that I am going to enter upon the much discussed subject of heredity, whether in its physiological or psychological aspects. It is a favorite subject just now.";
    private String text2 = "The island of Sicily, being in form nearly an equilateral triangle, with one side facing towards Italy, another towards Greece, and the third, towards Africa, was a tempting field for conquest to the various nations surrounding it. It was successively overrun by the Greeks, Carthaginians, and Romans, and later, after the Christian era, again successively by the Byzantines, the Moors, and the Normans.";
    private String text3 = "In executing this task I have found it very difficult to meet the requirements of those who are entirely ignorant of the science. It is only the adept who has already overcome the first steps as an observer, and is familiar with many of the technical terms, who can profit by a brief and concise manual. Beginners wish for a short and cheap book in which they may find a full explanation of the leading facts and principles of Geology.";
    private String text4 = "Here is one of the finest scholars, one of the most original men of genius, and one of the most industrious of the literary profession of our country, whose temporary suspension of labor, from bodily illness, drops him immediately to a level with the common objects of public charity. There is no intermediate stopping-place, no respectful shelter, where, with the delicacy due to genius and culture, he might secure aid.";
    //priva String text4 = "Here is one of the finest scholars, one of the most original men of genius, and one of the most industrious of the literary profession of our country, whose temporary suspension of labor, from bodily illness, drops him immediately to a level with the common objects of public charity. There is no intermediate stopping-place, no respectful shelter, where, with the delicacy due to genius and culture, he might secure aid, till, with returning h";
    public TextChooser()
    {

    }

    public String chooseText()
    {
        int rand = (int) (Math.random() * 5);
        if (rand == 0)
        {
            return text0;
        }
        else if (rand == 1)
        {
            return text1;
        }
        else if (rand == 2)
        {
            return text2;
        }
        else if (rand == 3)
        {
            return text3;
        }
        else
        {
            return text4;
        }
    }

    public String chooseText(int num)
    {
        if (num == 0)
        {
            return text0;
        }
        else if (num == 1)
        {
            return text1;
        }
        else if (num == 2)
        {
            return text2;
        }
        else if (num == 3)
        {
            return text3;
        }
        else
        {
            return text4;
        }
    }
}
