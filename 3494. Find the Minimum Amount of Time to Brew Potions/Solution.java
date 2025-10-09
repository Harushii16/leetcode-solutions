// LeetCode signature: public long minTime(int[] skill, int[] mana)
public class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long sumSkill = 0L;
        for (int s : skill) sumSkill += s;

        // time when the last wizard finishes the first potion
        long prevWizardDone = sumSkill * (long) mana[0];

        // process potions 1..m-1 (0-based)
        for (int j = 1; j < m; ++j) {
            long prevPotionDone = prevWizardDone;
            // iterate wizards from second-last down to first
            // to compute minimal safe offsets given the no-wait constraint
            for (int i = n - 2; i >= 0; --i) {
                // subtract time wizard (i+1) spent on previous potion
                prevPotionDone -= (long) skill[i + 1] * (long) mana[j - 1];

                // ensure wizard i can start potion j only after both:
                // 1) wizard i finished potion j-1 (prevPotionDone),
                // 2) wizard i's previous schedule shifted so wizard (i+1) is free:
                //    (prevWizardDone - skill[i]*mana[j]) is the latest constraint propagated backward
                prevWizardDone = Math.max(prevPotionDone,
                                          prevWizardDone - (long) skill[i] * (long) mana[j]);
            }
            // add the total time all wizards take for potion j to update finish time
            prevWizardDone += sumSkill * (long) mana[j];
        }

        return prevWizardDone;
    }
}
