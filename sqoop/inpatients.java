// ORM class for table 'inpatients'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sun Apr 22 09:50:14 COT 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class inpatients extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("RECORD_ID", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        RECORD_ID = (String)value;
      }
    });
    setters.put("DISCHARGE", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        DISCHARGE = (String)value;
      }
    });
    setters.put("THCIC_ID", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        THCIC_ID = (String)value;
      }
    });
    setters.put("TYPE_OF_ADMISSION", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        TYPE_OF_ADMISSION = (String)value;
      }
    });
    setters.put("SOURCE_OF_ADMISSION", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        SOURCE_OF_ADMISSION = (String)value;
      }
    });
    setters.put("PAT_STATE", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        PAT_STATE = (String)value;
      }
    });
    setters.put("PAT_COUNTRY", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        PAT_COUNTRY = (String)value;
      }
    });
    setters.put("COUNTY", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        COUNTY = (String)value;
      }
    });
    setters.put("PAT_STATUS", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        PAT_STATUS = (String)value;
      }
    });
    setters.put("SEX_CODE", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        SEX_CODE = (String)value;
      }
    });
    setters.put("PAT_AGE", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        PAT_AGE = (String)value;
      }
    });
    setters.put("ADMITTING_DIAGNOSIS", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ADMITTING_DIAGNOSIS = (String)value;
      }
    });
    setters.put("PRINC_DIAG_CODE", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        PRINC_DIAG_CODE = (String)value;
      }
    });
    setters.put("OTH_DIAG_CODES", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        OTH_DIAG_CODES = (String)value;
      }
    });
    setters.put("E_CODES", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        E_CODES = (String)value;
      }
    });
  }
  public inpatients() {
    init0();
  }
  private String RECORD_ID;
  public String get_RECORD_ID() {
    return RECORD_ID;
  }
  public void set_RECORD_ID(String RECORD_ID) {
    this.RECORD_ID = RECORD_ID;
  }
  public inpatients with_RECORD_ID(String RECORD_ID) {
    this.RECORD_ID = RECORD_ID;
    return this;
  }
  private String DISCHARGE;
  public String get_DISCHARGE() {
    return DISCHARGE;
  }
  public void set_DISCHARGE(String DISCHARGE) {
    this.DISCHARGE = DISCHARGE;
  }
  public inpatients with_DISCHARGE(String DISCHARGE) {
    this.DISCHARGE = DISCHARGE;
    return this;
  }
  private String THCIC_ID;
  public String get_THCIC_ID() {
    return THCIC_ID;
  }
  public void set_THCIC_ID(String THCIC_ID) {
    this.THCIC_ID = THCIC_ID;
  }
  public inpatients with_THCIC_ID(String THCIC_ID) {
    this.THCIC_ID = THCIC_ID;
    return this;
  }
  private String TYPE_OF_ADMISSION;
  public String get_TYPE_OF_ADMISSION() {
    return TYPE_OF_ADMISSION;
  }
  public void set_TYPE_OF_ADMISSION(String TYPE_OF_ADMISSION) {
    this.TYPE_OF_ADMISSION = TYPE_OF_ADMISSION;
  }
  public inpatients with_TYPE_OF_ADMISSION(String TYPE_OF_ADMISSION) {
    this.TYPE_OF_ADMISSION = TYPE_OF_ADMISSION;
    return this;
  }
  private String SOURCE_OF_ADMISSION;
  public String get_SOURCE_OF_ADMISSION() {
    return SOURCE_OF_ADMISSION;
  }
  public void set_SOURCE_OF_ADMISSION(String SOURCE_OF_ADMISSION) {
    this.SOURCE_OF_ADMISSION = SOURCE_OF_ADMISSION;
  }
  public inpatients with_SOURCE_OF_ADMISSION(String SOURCE_OF_ADMISSION) {
    this.SOURCE_OF_ADMISSION = SOURCE_OF_ADMISSION;
    return this;
  }
  private String PAT_STATE;
  public String get_PAT_STATE() {
    return PAT_STATE;
  }
  public void set_PAT_STATE(String PAT_STATE) {
    this.PAT_STATE = PAT_STATE;
  }
  public inpatients with_PAT_STATE(String PAT_STATE) {
    this.PAT_STATE = PAT_STATE;
    return this;
  }
  private String PAT_COUNTRY;
  public String get_PAT_COUNTRY() {
    return PAT_COUNTRY;
  }
  public void set_PAT_COUNTRY(String PAT_COUNTRY) {
    this.PAT_COUNTRY = PAT_COUNTRY;
  }
  public inpatients with_PAT_COUNTRY(String PAT_COUNTRY) {
    this.PAT_COUNTRY = PAT_COUNTRY;
    return this;
  }
  private String COUNTY;
  public String get_COUNTY() {
    return COUNTY;
  }
  public void set_COUNTY(String COUNTY) {
    this.COUNTY = COUNTY;
  }
  public inpatients with_COUNTY(String COUNTY) {
    this.COUNTY = COUNTY;
    return this;
  }
  private String PAT_STATUS;
  public String get_PAT_STATUS() {
    return PAT_STATUS;
  }
  public void set_PAT_STATUS(String PAT_STATUS) {
    this.PAT_STATUS = PAT_STATUS;
  }
  public inpatients with_PAT_STATUS(String PAT_STATUS) {
    this.PAT_STATUS = PAT_STATUS;
    return this;
  }
  private String SEX_CODE;
  public String get_SEX_CODE() {
    return SEX_CODE;
  }
  public void set_SEX_CODE(String SEX_CODE) {
    this.SEX_CODE = SEX_CODE;
  }
  public inpatients with_SEX_CODE(String SEX_CODE) {
    this.SEX_CODE = SEX_CODE;
    return this;
  }
  private String PAT_AGE;
  public String get_PAT_AGE() {
    return PAT_AGE;
  }
  public void set_PAT_AGE(String PAT_AGE) {
    this.PAT_AGE = PAT_AGE;
  }
  public inpatients with_PAT_AGE(String PAT_AGE) {
    this.PAT_AGE = PAT_AGE;
    return this;
  }
  private String ADMITTING_DIAGNOSIS;
  public String get_ADMITTING_DIAGNOSIS() {
    return ADMITTING_DIAGNOSIS;
  }
  public void set_ADMITTING_DIAGNOSIS(String ADMITTING_DIAGNOSIS) {
    this.ADMITTING_DIAGNOSIS = ADMITTING_DIAGNOSIS;
  }
  public inpatients with_ADMITTING_DIAGNOSIS(String ADMITTING_DIAGNOSIS) {
    this.ADMITTING_DIAGNOSIS = ADMITTING_DIAGNOSIS;
    return this;
  }
  private String PRINC_DIAG_CODE;
  public String get_PRINC_DIAG_CODE() {
    return PRINC_DIAG_CODE;
  }
  public void set_PRINC_DIAG_CODE(String PRINC_DIAG_CODE) {
    this.PRINC_DIAG_CODE = PRINC_DIAG_CODE;
  }
  public inpatients with_PRINC_DIAG_CODE(String PRINC_DIAG_CODE) {
    this.PRINC_DIAG_CODE = PRINC_DIAG_CODE;
    return this;
  }
  private String OTH_DIAG_CODES;
  public String get_OTH_DIAG_CODES() {
    return OTH_DIAG_CODES;
  }
  public void set_OTH_DIAG_CODES(String OTH_DIAG_CODES) {
    this.OTH_DIAG_CODES = OTH_DIAG_CODES;
  }
  public inpatients with_OTH_DIAG_CODES(String OTH_DIAG_CODES) {
    this.OTH_DIAG_CODES = OTH_DIAG_CODES;
    return this;
  }
  private String E_CODES;
  public String get_E_CODES() {
    return E_CODES;
  }
  public void set_E_CODES(String E_CODES) {
    this.E_CODES = E_CODES;
  }
  public inpatients with_E_CODES(String E_CODES) {
    this.E_CODES = E_CODES;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof inpatients)) {
      return false;
    }
    inpatients that = (inpatients) o;
    boolean equal = true;
    equal = equal && (this.RECORD_ID == null ? that.RECORD_ID == null : this.RECORD_ID.equals(that.RECORD_ID));
    equal = equal && (this.DISCHARGE == null ? that.DISCHARGE == null : this.DISCHARGE.equals(that.DISCHARGE));
    equal = equal && (this.THCIC_ID == null ? that.THCIC_ID == null : this.THCIC_ID.equals(that.THCIC_ID));
    equal = equal && (this.TYPE_OF_ADMISSION == null ? that.TYPE_OF_ADMISSION == null : this.TYPE_OF_ADMISSION.equals(that.TYPE_OF_ADMISSION));
    equal = equal && (this.SOURCE_OF_ADMISSION == null ? that.SOURCE_OF_ADMISSION == null : this.SOURCE_OF_ADMISSION.equals(that.SOURCE_OF_ADMISSION));
    equal = equal && (this.PAT_STATE == null ? that.PAT_STATE == null : this.PAT_STATE.equals(that.PAT_STATE));
    equal = equal && (this.PAT_COUNTRY == null ? that.PAT_COUNTRY == null : this.PAT_COUNTRY.equals(that.PAT_COUNTRY));
    equal = equal && (this.COUNTY == null ? that.COUNTY == null : this.COUNTY.equals(that.COUNTY));
    equal = equal && (this.PAT_STATUS == null ? that.PAT_STATUS == null : this.PAT_STATUS.equals(that.PAT_STATUS));
    equal = equal && (this.SEX_CODE == null ? that.SEX_CODE == null : this.SEX_CODE.equals(that.SEX_CODE));
    equal = equal && (this.PAT_AGE == null ? that.PAT_AGE == null : this.PAT_AGE.equals(that.PAT_AGE));
    equal = equal && (this.ADMITTING_DIAGNOSIS == null ? that.ADMITTING_DIAGNOSIS == null : this.ADMITTING_DIAGNOSIS.equals(that.ADMITTING_DIAGNOSIS));
    equal = equal && (this.PRINC_DIAG_CODE == null ? that.PRINC_DIAG_CODE == null : this.PRINC_DIAG_CODE.equals(that.PRINC_DIAG_CODE));
    equal = equal && (this.OTH_DIAG_CODES == null ? that.OTH_DIAG_CODES == null : this.OTH_DIAG_CODES.equals(that.OTH_DIAG_CODES));
    equal = equal && (this.E_CODES == null ? that.E_CODES == null : this.E_CODES.equals(that.E_CODES));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof inpatients)) {
      return false;
    }
    inpatients that = (inpatients) o;
    boolean equal = true;
    equal = equal && (this.RECORD_ID == null ? that.RECORD_ID == null : this.RECORD_ID.equals(that.RECORD_ID));
    equal = equal && (this.DISCHARGE == null ? that.DISCHARGE == null : this.DISCHARGE.equals(that.DISCHARGE));
    equal = equal && (this.THCIC_ID == null ? that.THCIC_ID == null : this.THCIC_ID.equals(that.THCIC_ID));
    equal = equal && (this.TYPE_OF_ADMISSION == null ? that.TYPE_OF_ADMISSION == null : this.TYPE_OF_ADMISSION.equals(that.TYPE_OF_ADMISSION));
    equal = equal && (this.SOURCE_OF_ADMISSION == null ? that.SOURCE_OF_ADMISSION == null : this.SOURCE_OF_ADMISSION.equals(that.SOURCE_OF_ADMISSION));
    equal = equal && (this.PAT_STATE == null ? that.PAT_STATE == null : this.PAT_STATE.equals(that.PAT_STATE));
    equal = equal && (this.PAT_COUNTRY == null ? that.PAT_COUNTRY == null : this.PAT_COUNTRY.equals(that.PAT_COUNTRY));
    equal = equal && (this.COUNTY == null ? that.COUNTY == null : this.COUNTY.equals(that.COUNTY));
    equal = equal && (this.PAT_STATUS == null ? that.PAT_STATUS == null : this.PAT_STATUS.equals(that.PAT_STATUS));
    equal = equal && (this.SEX_CODE == null ? that.SEX_CODE == null : this.SEX_CODE.equals(that.SEX_CODE));
    equal = equal && (this.PAT_AGE == null ? that.PAT_AGE == null : this.PAT_AGE.equals(that.PAT_AGE));
    equal = equal && (this.ADMITTING_DIAGNOSIS == null ? that.ADMITTING_DIAGNOSIS == null : this.ADMITTING_DIAGNOSIS.equals(that.ADMITTING_DIAGNOSIS));
    equal = equal && (this.PRINC_DIAG_CODE == null ? that.PRINC_DIAG_CODE == null : this.PRINC_DIAG_CODE.equals(that.PRINC_DIAG_CODE));
    equal = equal && (this.OTH_DIAG_CODES == null ? that.OTH_DIAG_CODES == null : this.OTH_DIAG_CODES.equals(that.OTH_DIAG_CODES));
    equal = equal && (this.E_CODES == null ? that.E_CODES == null : this.E_CODES.equals(that.E_CODES));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.RECORD_ID = JdbcWritableBridge.readString(1, __dbResults);
    this.DISCHARGE = JdbcWritableBridge.readString(2, __dbResults);
    this.THCIC_ID = JdbcWritableBridge.readString(3, __dbResults);
    this.TYPE_OF_ADMISSION = JdbcWritableBridge.readString(4, __dbResults);
    this.SOURCE_OF_ADMISSION = JdbcWritableBridge.readString(5, __dbResults);
    this.PAT_STATE = JdbcWritableBridge.readString(6, __dbResults);
    this.PAT_COUNTRY = JdbcWritableBridge.readString(7, __dbResults);
    this.COUNTY = JdbcWritableBridge.readString(8, __dbResults);
    this.PAT_STATUS = JdbcWritableBridge.readString(9, __dbResults);
    this.SEX_CODE = JdbcWritableBridge.readString(10, __dbResults);
    this.PAT_AGE = JdbcWritableBridge.readString(11, __dbResults);
    this.ADMITTING_DIAGNOSIS = JdbcWritableBridge.readString(12, __dbResults);
    this.PRINC_DIAG_CODE = JdbcWritableBridge.readString(13, __dbResults);
    this.OTH_DIAG_CODES = JdbcWritableBridge.readString(14, __dbResults);
    this.E_CODES = JdbcWritableBridge.readString(15, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.RECORD_ID = JdbcWritableBridge.readString(1, __dbResults);
    this.DISCHARGE = JdbcWritableBridge.readString(2, __dbResults);
    this.THCIC_ID = JdbcWritableBridge.readString(3, __dbResults);
    this.TYPE_OF_ADMISSION = JdbcWritableBridge.readString(4, __dbResults);
    this.SOURCE_OF_ADMISSION = JdbcWritableBridge.readString(5, __dbResults);
    this.PAT_STATE = JdbcWritableBridge.readString(6, __dbResults);
    this.PAT_COUNTRY = JdbcWritableBridge.readString(7, __dbResults);
    this.COUNTY = JdbcWritableBridge.readString(8, __dbResults);
    this.PAT_STATUS = JdbcWritableBridge.readString(9, __dbResults);
    this.SEX_CODE = JdbcWritableBridge.readString(10, __dbResults);
    this.PAT_AGE = JdbcWritableBridge.readString(11, __dbResults);
    this.ADMITTING_DIAGNOSIS = JdbcWritableBridge.readString(12, __dbResults);
    this.PRINC_DIAG_CODE = JdbcWritableBridge.readString(13, __dbResults);
    this.OTH_DIAG_CODES = JdbcWritableBridge.readString(14, __dbResults);
    this.E_CODES = JdbcWritableBridge.readString(15, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(RECORD_ID, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DISCHARGE, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(THCIC_ID, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(TYPE_OF_ADMISSION, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(SOURCE_OF_ADMISSION, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_STATE, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_COUNTRY, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(COUNTY, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_STATUS, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(SEX_CODE, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_AGE, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ADMITTING_DIAGNOSIS, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PRINC_DIAG_CODE, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(OTH_DIAG_CODES, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(E_CODES, 15 + __off, 12, __dbStmt);
    return 15;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(RECORD_ID, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DISCHARGE, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(THCIC_ID, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(TYPE_OF_ADMISSION, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(SOURCE_OF_ADMISSION, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_STATE, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_COUNTRY, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(COUNTY, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_STATUS, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(SEX_CODE, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PAT_AGE, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ADMITTING_DIAGNOSIS, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PRINC_DIAG_CODE, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(OTH_DIAG_CODES, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(E_CODES, 15 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.RECORD_ID = null;
    } else {
    this.RECORD_ID = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.DISCHARGE = null;
    } else {
    this.DISCHARGE = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.THCIC_ID = null;
    } else {
    this.THCIC_ID = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.TYPE_OF_ADMISSION = null;
    } else {
    this.TYPE_OF_ADMISSION = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.SOURCE_OF_ADMISSION = null;
    } else {
    this.SOURCE_OF_ADMISSION = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PAT_STATE = null;
    } else {
    this.PAT_STATE = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PAT_COUNTRY = null;
    } else {
    this.PAT_COUNTRY = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.COUNTY = null;
    } else {
    this.COUNTY = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PAT_STATUS = null;
    } else {
    this.PAT_STATUS = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.SEX_CODE = null;
    } else {
    this.SEX_CODE = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PAT_AGE = null;
    } else {
    this.PAT_AGE = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ADMITTING_DIAGNOSIS = null;
    } else {
    this.ADMITTING_DIAGNOSIS = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PRINC_DIAG_CODE = null;
    } else {
    this.PRINC_DIAG_CODE = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.OTH_DIAG_CODES = null;
    } else {
    this.OTH_DIAG_CODES = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.E_CODES = null;
    } else {
    this.E_CODES = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.RECORD_ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, RECORD_ID);
    }
    if (null == this.DISCHARGE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DISCHARGE);
    }
    if (null == this.THCIC_ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, THCIC_ID);
    }
    if (null == this.TYPE_OF_ADMISSION) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, TYPE_OF_ADMISSION);
    }
    if (null == this.SOURCE_OF_ADMISSION) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, SOURCE_OF_ADMISSION);
    }
    if (null == this.PAT_STATE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_STATE);
    }
    if (null == this.PAT_COUNTRY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_COUNTRY);
    }
    if (null == this.COUNTY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, COUNTY);
    }
    if (null == this.PAT_STATUS) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_STATUS);
    }
    if (null == this.SEX_CODE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, SEX_CODE);
    }
    if (null == this.PAT_AGE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_AGE);
    }
    if (null == this.ADMITTING_DIAGNOSIS) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ADMITTING_DIAGNOSIS);
    }
    if (null == this.PRINC_DIAG_CODE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PRINC_DIAG_CODE);
    }
    if (null == this.OTH_DIAG_CODES) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, OTH_DIAG_CODES);
    }
    if (null == this.E_CODES) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, E_CODES);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.RECORD_ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, RECORD_ID);
    }
    if (null == this.DISCHARGE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DISCHARGE);
    }
    if (null == this.THCIC_ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, THCIC_ID);
    }
    if (null == this.TYPE_OF_ADMISSION) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, TYPE_OF_ADMISSION);
    }
    if (null == this.SOURCE_OF_ADMISSION) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, SOURCE_OF_ADMISSION);
    }
    if (null == this.PAT_STATE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_STATE);
    }
    if (null == this.PAT_COUNTRY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_COUNTRY);
    }
    if (null == this.COUNTY) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, COUNTY);
    }
    if (null == this.PAT_STATUS) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_STATUS);
    }
    if (null == this.SEX_CODE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, SEX_CODE);
    }
    if (null == this.PAT_AGE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PAT_AGE);
    }
    if (null == this.ADMITTING_DIAGNOSIS) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ADMITTING_DIAGNOSIS);
    }
    if (null == this.PRINC_DIAG_CODE) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PRINC_DIAG_CODE);
    }
    if (null == this.OTH_DIAG_CODES) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, OTH_DIAG_CODES);
    }
    if (null == this.E_CODES) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, E_CODES);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(RECORD_ID==null?"null":RECORD_ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DISCHARGE==null?"null":DISCHARGE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(THCIC_ID==null?"null":THCIC_ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(TYPE_OF_ADMISSION==null?"null":TYPE_OF_ADMISSION, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SOURCE_OF_ADMISSION==null?"null":SOURCE_OF_ADMISSION, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_STATE==null?"null":PAT_STATE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_COUNTRY==null?"null":PAT_COUNTRY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(COUNTY==null?"null":COUNTY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_STATUS==null?"null":PAT_STATUS, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SEX_CODE==null?"null":SEX_CODE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_AGE==null?"null":PAT_AGE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ADMITTING_DIAGNOSIS==null?"null":ADMITTING_DIAGNOSIS, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PRINC_DIAG_CODE==null?"null":PRINC_DIAG_CODE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(OTH_DIAG_CODES==null?"null":OTH_DIAG_CODES, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(E_CODES==null?"null":E_CODES, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(RECORD_ID==null?"null":RECORD_ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DISCHARGE==null?"null":DISCHARGE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(THCIC_ID==null?"null":THCIC_ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(TYPE_OF_ADMISSION==null?"null":TYPE_OF_ADMISSION, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SOURCE_OF_ADMISSION==null?"null":SOURCE_OF_ADMISSION, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_STATE==null?"null":PAT_STATE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_COUNTRY==null?"null":PAT_COUNTRY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(COUNTY==null?"null":COUNTY, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_STATUS==null?"null":PAT_STATUS, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(SEX_CODE==null?"null":SEX_CODE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PAT_AGE==null?"null":PAT_AGE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ADMITTING_DIAGNOSIS==null?"null":ADMITTING_DIAGNOSIS, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PRINC_DIAG_CODE==null?"null":PRINC_DIAG_CODE, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(OTH_DIAG_CODES==null?"null":OTH_DIAG_CODES, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(E_CODES==null?"null":E_CODES, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.RECORD_ID = null; } else {
      this.RECORD_ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DISCHARGE = null; } else {
      this.DISCHARGE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.THCIC_ID = null; } else {
      this.THCIC_ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.TYPE_OF_ADMISSION = null; } else {
      this.TYPE_OF_ADMISSION = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.SOURCE_OF_ADMISSION = null; } else {
      this.SOURCE_OF_ADMISSION = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_STATE = null; } else {
      this.PAT_STATE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_COUNTRY = null; } else {
      this.PAT_COUNTRY = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.COUNTY = null; } else {
      this.COUNTY = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_STATUS = null; } else {
      this.PAT_STATUS = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.SEX_CODE = null; } else {
      this.SEX_CODE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_AGE = null; } else {
      this.PAT_AGE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ADMITTING_DIAGNOSIS = null; } else {
      this.ADMITTING_DIAGNOSIS = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PRINC_DIAG_CODE = null; } else {
      this.PRINC_DIAG_CODE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.OTH_DIAG_CODES = null; } else {
      this.OTH_DIAG_CODES = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.E_CODES = null; } else {
      this.E_CODES = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.RECORD_ID = null; } else {
      this.RECORD_ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DISCHARGE = null; } else {
      this.DISCHARGE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.THCIC_ID = null; } else {
      this.THCIC_ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.TYPE_OF_ADMISSION = null; } else {
      this.TYPE_OF_ADMISSION = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.SOURCE_OF_ADMISSION = null; } else {
      this.SOURCE_OF_ADMISSION = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_STATE = null; } else {
      this.PAT_STATE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_COUNTRY = null; } else {
      this.PAT_COUNTRY = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.COUNTY = null; } else {
      this.COUNTY = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_STATUS = null; } else {
      this.PAT_STATUS = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.SEX_CODE = null; } else {
      this.SEX_CODE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PAT_AGE = null; } else {
      this.PAT_AGE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ADMITTING_DIAGNOSIS = null; } else {
      this.ADMITTING_DIAGNOSIS = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PRINC_DIAG_CODE = null; } else {
      this.PRINC_DIAG_CODE = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.OTH_DIAG_CODES = null; } else {
      this.OTH_DIAG_CODES = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.E_CODES = null; } else {
      this.E_CODES = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    inpatients o = (inpatients) super.clone();
    return o;
  }

  public void clone0(inpatients o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("RECORD_ID", this.RECORD_ID);
    __sqoop$field_map.put("DISCHARGE", this.DISCHARGE);
    __sqoop$field_map.put("THCIC_ID", this.THCIC_ID);
    __sqoop$field_map.put("TYPE_OF_ADMISSION", this.TYPE_OF_ADMISSION);
    __sqoop$field_map.put("SOURCE_OF_ADMISSION", this.SOURCE_OF_ADMISSION);
    __sqoop$field_map.put("PAT_STATE", this.PAT_STATE);
    __sqoop$field_map.put("PAT_COUNTRY", this.PAT_COUNTRY);
    __sqoop$field_map.put("COUNTY", this.COUNTY);
    __sqoop$field_map.put("PAT_STATUS", this.PAT_STATUS);
    __sqoop$field_map.put("SEX_CODE", this.SEX_CODE);
    __sqoop$field_map.put("PAT_AGE", this.PAT_AGE);
    __sqoop$field_map.put("ADMITTING_DIAGNOSIS", this.ADMITTING_DIAGNOSIS);
    __sqoop$field_map.put("PRINC_DIAG_CODE", this.PRINC_DIAG_CODE);
    __sqoop$field_map.put("OTH_DIAG_CODES", this.OTH_DIAG_CODES);
    __sqoop$field_map.put("E_CODES", this.E_CODES);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("RECORD_ID", this.RECORD_ID);
    __sqoop$field_map.put("DISCHARGE", this.DISCHARGE);
    __sqoop$field_map.put("THCIC_ID", this.THCIC_ID);
    __sqoop$field_map.put("TYPE_OF_ADMISSION", this.TYPE_OF_ADMISSION);
    __sqoop$field_map.put("SOURCE_OF_ADMISSION", this.SOURCE_OF_ADMISSION);
    __sqoop$field_map.put("PAT_STATE", this.PAT_STATE);
    __sqoop$field_map.put("PAT_COUNTRY", this.PAT_COUNTRY);
    __sqoop$field_map.put("COUNTY", this.COUNTY);
    __sqoop$field_map.put("PAT_STATUS", this.PAT_STATUS);
    __sqoop$field_map.put("SEX_CODE", this.SEX_CODE);
    __sqoop$field_map.put("PAT_AGE", this.PAT_AGE);
    __sqoop$field_map.put("ADMITTING_DIAGNOSIS", this.ADMITTING_DIAGNOSIS);
    __sqoop$field_map.put("PRINC_DIAG_CODE", this.PRINC_DIAG_CODE);
    __sqoop$field_map.put("OTH_DIAG_CODES", this.OTH_DIAG_CODES);
    __sqoop$field_map.put("E_CODES", this.E_CODES);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
