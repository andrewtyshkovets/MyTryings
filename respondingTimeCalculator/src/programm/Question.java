package programm;

import java.util.Optional;

public class Question {
    private Optional<Integer> questionTypeId;
    private Optional<Integer> categoryId;
    private Optional<Integer> subCategoryId;
    private boolean matchAll = false;


    public Question(String str) {
        if (str.equals("*")) {
            this.questionTypeId = Optional.empty();
            this.categoryId = Optional.empty();
            this.subCategoryId = Optional.empty();
            this.matchAll = true;
        } else {
            String[] arr = str.split("[.]");
            String[] temp = new String[3];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            this.questionTypeId = Optional.of(Integer.parseInt(temp[0]));
            if (temp[1] != null) {
                this.categoryId = Optional.of(Integer.parseInt(temp[1]));
            } else {
                this.categoryId = Optional.empty();
            }
            if (temp[2] != null) {
                this.subCategoryId = Optional.of(Integer.parseInt(temp[2]));
            } else {
                this.subCategoryId = Optional.empty();
            }
        }
    }

    public Optional<Integer> getQuestionTypeId() {
        return questionTypeId;
    }

    public Optional<Integer> getCategoryId() {
        return categoryId;
    }

    public Optional<Integer> getSubCategoryId() {
        return subCategoryId;
    }

    public boolean isMatchAll() {
        return matchAll;
    }

    public boolean compareQuestions(Question timeLineQuestion) {
        if (matchAll == true) {
            return true;
        } else {
            if (timeLineQuestion.questionTypeId.equals(this.questionTypeId)) {
                if (!this.categoryId.isEmpty() && timeLineQuestion.getCategoryId().equals(this.categoryId)) {
                    if (!this.subCategoryId.isEmpty() && !timeLineQuestion.getSubCategoryId().equals(this.subCategoryId)) {
                        return false;
                    }
                    return true;
                } else if (!this.categoryId.isEmpty() && !timeLineQuestion.getCategoryId().equals(this.categoryId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                '}';
    }
}
