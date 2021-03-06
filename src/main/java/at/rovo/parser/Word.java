package at.rovo.parser;

/**
 * Represents a typical CDATA part in HTML or XML. This means text between two tags, f.e.: in the following code-snippet
 * 'Example' is the CDATA part of this code: <code>&lt;p>Example&lt;/p></code>
 *
 * @author Roman Vottner
 */
@SuppressWarnings("unused")
public class Word extends Token
{
    /**
     * Initializes a new instance of a CDATA part of a HTML code
     *
     * @param text The actual word
     */
    public Word(String text)
    {
        super(text);
    }

    public Word(int id, String name, int parent, int numSiblings, int level)
    {
        super(id, name, name, level, parent, numSiblings);
    }

    public Word(Token node)
    {
        super(node);

        if (node != null)
        {
            // deep copy
            if (node.matchedNode != null)
            {
                if (node.matchedNode instanceof Word)
                {
                    this.matchedNode = new Word((Word) node.matchedNode);
                }
                else
                {
                    this.matchedNode = new Tag((Tag) node.matchedNode);
                }
            }
        }
    }

    public Word(Word node)
    {
        super(node);
        if (node != null)
        {
            // deep copy
            if (node.matchedNode != null)
            {
                this.matchedNode = new Word((Word) node.matchedNode);
            }
        }
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + this.text.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        Word word;

        if (this.text == null && obj == null)
        {
            return true;
        }
        else if (this.text == null || obj == null)
        {
            return false;
        }

        if (obj instanceof Word)
        {
            word = (Word) obj;

            if (!(this.text.equalsIgnoreCase(word.text)))
            {
                return false;
            }
        }
        else
        {
            return false;
        }

        return true;
    }
}
