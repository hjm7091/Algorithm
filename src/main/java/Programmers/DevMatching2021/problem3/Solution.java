package Programmers.DevMatching2021.problem3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Member {
    String name;
    double profit;
    Member referral;

    public Member(String name) {
        this.name = name;
    }

    public boolean isMinHo() {
        return name.equals("-");
    }
}

public class Solution {

    Map<String, Member> organization = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        initOrganization(enroll, referral);

        distributeProfit(seller, amount);

        return Arrays.stream(enroll)
                .map(name -> (int) organization.get(name).profit)
                .mapToInt(Integer::intValue).toArray();
    }

    private void initOrganization(String[] enroll, String[] referral) {

        for (String name : enroll) {
            Member member = new Member(name);
            organization.put(name, member);
        }
        organization.put("-", new Member("-"));

        for (int i = 0; i < referral.length; i++) {
            organization.get(enroll[i]).referral = organization.get(referral[i]);
        }

    }

    private void distributeProfit(String[] sellers, int[] amounts) {
        for (int i = 0; i < sellers.length; i++) {
            Member member = organization.get(sellers[i]);
            double amount = amounts[i] * 100D;
            
            while (member != null) {
                double divided = amount * 0.1;
                double floored = Math.floor(divided);

                if (divided < 1D || member.isMinHo()) {
                    member.profit += amount;
                    break;
                }

                member.profit += (amount - floored);
                member = member.referral;
                amount = floored;
            }
        }
    }

}
