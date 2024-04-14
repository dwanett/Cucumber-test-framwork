package steps.fragment;

import fragment.FragmentReplacer;
import io.cucumber.java.ru.И;


public class FragmentStep {

    @И(FragmentReplacer.REGEX_FRAGMENT)
    public void userInsertsFragment(String fragmentName) {
        throw new IllegalStateException("фрагмент не подставился");
    }

    /**
     * Шаг-заглушка для отчета аллюра и группировки шагов фрагмента под спойлер
     * Если будет использоваться в тесте - будет assert "надо использовать другой шаг"
     * @param fragmentName  - название фрагмента (сценария)
     */
    @И(FragmentReplacer.REGEX_FRAGMENT_SPOILER)
    public void fragment(String fragmentName) {
    }

}
