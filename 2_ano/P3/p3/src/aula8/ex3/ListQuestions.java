/**
 * 
 */
package aula8.ex3;

import java.io.IOException;
import java.util.LinkedList;

/**
 * @author João Moura
 *
 */
public class ListQuestions {
	private static final int[] prizes = {
    		25, 50, 125, 250, 500, 750, 1500, 1500, 2500, 5000, 10000, 16000, 32000, 64000, 125000, 250000
            };
    private final Question[] questions;
    private int idx;

    public ListQuestions(final String fName) throws IOException 
    {
        LinkedList<Question> tmp = new LinkedList<>();
        ReadFile.parse(tmp, fName);
        this.questions = ReadFile.sort(tmp.toArray(new Question[tmp.size()]));
        applyPrizes(this);
    }

    private static void applyPrizes(final ListQuestions quests) 
    {
        int i = 0;
        for (Question q : quests.questions)
            q.setPrize(prizes[i++]);
    }

    public Question getQuestion() 
    {
        return idx < questions.length ? questions[idx++] : null;
    }

    public int lastQuestionPrize() 
    {
        return idx > 0 ? questions[idx - 1].getPrize() : 0;
    }

    public boolean noOtherQuestion() 
    {
        return idx >= questions.length;
    }
}
