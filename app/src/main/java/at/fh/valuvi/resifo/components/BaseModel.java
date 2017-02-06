package at.fh.valuvi.resifo.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

public class BaseModel {

    public @interface DataType {
        public static final int DATETIME = 1;
        public int type();
    }

    public @interface Required {}

    public @interface Length {
        public static final long NONE = -1;
        public long min() default 0;
        public long max() default NONE;
    }

    public @interface Email {}

    public @interface Equal {
        public String compareAttributeName();
    }

    public @interface Unique {}

    public @interface AllowedValues {
        public String[] values();
    }

    protected HashMap<String, String> errors = new HashMap<>();

    public Boolean validate() {
        for (Field field: getFields()) {
            try {
                Required requiredValidator = field.getAnnotation(Required.class);
                Length lengthValidator = field.getAnnotation(Length.class);
                Email emailValidator = field.getAnnotation(Email.class);
                Equal equalValidator = field.getAnnotation(Equal.class);
                Unique uniqueValidator = field.getAnnotation(Unique.class);
                AllowedValues allowedValidator = field.getAnnotation(AllowedValues.class);

                String fieldName = field.getName();
                Object fieldValue = field.get(this);

                // Required Validation
                if (requiredValidator != null && fieldValue.equals("")) {
                    addError(fieldName, String.format("Field %s cannot be blank", fieldName));
                }

                // Length Validation
                if (lengthValidator != null) {
                    if (fieldValue.toString().length() < lengthValidator.min()) {
                        addError(
                                fieldName,
                                String.format("Field %s cannot be shorter than %s characters",
                                        fieldName,
                                        lengthValidator.min()
                                )
                        );
                    }
                    if (lengthValidator.max() != Length.NONE && fieldValue.toString().length() > lengthValidator.max()) {
                        addError(
                                fieldName,
                                String.format("Field %s cannot be longer than %s characters",
                                        fieldName,
                                        lengthValidator.max()
                                )
                        );
                    }
                }

                // Email Validation
                if (emailValidator != null) {
                    Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

                }

                // Equal Validation
                if (equalValidator != null) {
                    try {
                        Field compareField = this.getClass().getField(equalValidator.compareAttributeName());
                        System.out.println("POWER COMPARISON");

                        Object a = compareField.get(this);
                        System.out.println("A: " + a);
                        System.out.println("B: " + fieldValue);

                        if (!field.get(this).equals(compareField.get(this))) {
                            addError(fieldName, String.format("Fields %s and %s must be equal", fieldName, compareField.getName()));
                        }
                    } catch (Exception e) { System.out.println(e); }
                }

            } catch (Exception e) { System.out.println(e); }
        }

        return !hasErrors();
    }

    public void addError(String fieldName, String errorMessage) {
        errors.put(fieldName, errorMessage);
    }

    public Boolean hasErrors() {
        return errors.size() > 0;
    }

    public HashMap<String, String> getErrors() { return errors; }

    protected String getDbDateString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

        return fmt.format(date);
    }

    protected String getDbDateTimeString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return fmt.format(date);
    }

    protected Object getNewModelInstance() {
        Object model = new Object();
        try {
            Class<?> modelClass = Class.forName(this.getClass().getName());
            Constructor<?> modelConstructor = modelClass.getConstructor();
            model = modelConstructor.newInstance();
        } catch (Exception e) { System.out.println(e); }

        return model;
    }

    protected Field[] getFields() {
        return this.getClass().getDeclaredFields();
    }

}
