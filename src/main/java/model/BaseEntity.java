package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Galinka on 27.04.2017.
 */
public interface BaseEntity {
    int getId();
    void setId(int id);

    void setValue(String field, String value);
}
