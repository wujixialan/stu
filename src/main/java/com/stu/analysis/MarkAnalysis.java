package com.stu.analysis;

import com.stu.entity.Mark;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MarkAnalysis {
    public MarkAnalysisModel analysis(List<Mark> marks) {
        MarkAnalysisModel model = new MarkAnalysisModel();
        AtomicReference<Double> score = new AtomicReference<>((double) 0);
        AtomicReference<Double> credit = new AtomicReference<>((double) 0);
        AtomicReference<Double> gpa = new AtomicReference<>((double) 0);
        marks.stream().forEach(ele -> {
            if (!ele.getStudy().equals("初修")) {
                /**
                 * 如果不等于初修，即挂过科。挂科数目加1；
                 */
                model.setHang(model.getHang() + 1);
            }
            if (ele.getScore() >= 60) {
                /**
                 * 设置总成绩
                 */
                score.set(ele.getScore() + score.get());
                model.setScore(score.get());
                /**
                 * 设置总学分
                 */
                credit.set(ele.getCredit() + credit.get());
                model.setCredit(credit.get());
                /**
                 * 设置总绩点
                 */
                gpa.set(ele.getGpa() + gpa.get());
                model.setGpa(gpa.get());
            }
        });
        model.setScore(model.getScore() / marks.size());
        model.setGpa(model.getGpa() / marks.size());
        return model;
    }
}
