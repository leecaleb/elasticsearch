/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.elasticsearch.thrift;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.protocol.*;

import java.nio.ByteBuffer;
import java.util.*;

public class RestRequest implements TBase<RestRequest, RestRequest._Fields>, java.io.Serializable, Cloneable {
    private static final TStruct STRUCT_DESC = new TStruct("RestRequest");

    private static final TField METHOD_FIELD_DESC = new TField("method", TType.I32, (short) 1);
    private static final TField URI_FIELD_DESC = new TField("uri", TType.STRING, (short) 2);
    private static final TField PARAMETERS_FIELD_DESC = new TField("parameters", TType.MAP, (short) 3);
    private static final TField HEADERS_FIELD_DESC = new TField("headers", TType.MAP, (short) 4);
    private static final TField BODY_FIELD_DESC = new TField("body", TType.STRING, (short) 5);

    /**
     * @see org.elasticsearch.thrift.Method
     */
    public Method method;
    public String uri;
    public Map<String, String> parameters;
    public Map<String, String> headers;
    public ByteBuffer body;

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements TFieldIdEnum {
        /**
         * @see org.elasticsearch.thrift.Method
         */
        METHOD((short) 1, "method"),
        URI((short) 2, "uri"),
        PARAMETERS((short) 3, "parameters"),
        HEADERS((short) 4, "headers"),
        BODY((short) 5, "body");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // METHOD
                    return METHOD;
                case 2: // URI
                    return URI;
                case 3: // PARAMETERS
                    return PARAMETERS;
                case 4: // HEADERS
                    return HEADERS;
                case 5: // BODY
                    return BODY;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments

    public static final Map<_Fields, FieldMetaData> metaDataMap;

    static {
        Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.METHOD, new FieldMetaData("method", TFieldRequirementType.REQUIRED,
                new EnumMetaData(TType.ENUM, Method.class)));
        tmpMap.put(_Fields.URI, new FieldMetaData("uri", TFieldRequirementType.REQUIRED,
                new FieldValueMetaData(TType.STRING)));
        tmpMap.put(_Fields.PARAMETERS, new FieldMetaData("parameters", TFieldRequirementType.OPTIONAL,
                new MapMetaData(TType.MAP,
                        new FieldValueMetaData(TType.STRING),
                        new FieldValueMetaData(TType.STRING))));
        tmpMap.put(_Fields.HEADERS, new FieldMetaData("headers", TFieldRequirementType.OPTIONAL,
                new MapMetaData(TType.MAP,
                        new FieldValueMetaData(TType.STRING),
                        new FieldValueMetaData(TType.STRING))));
        tmpMap.put(_Fields.BODY, new FieldMetaData("body", TFieldRequirementType.OPTIONAL,
                new FieldValueMetaData(TType.STRING)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        FieldMetaData.addStructMetaDataMap(RestRequest.class, metaDataMap);
    }

    public RestRequest() {
    }

    public RestRequest(
            Method method,
            String uri) {
        this();
        this.method = method;
        this.uri = uri;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public RestRequest(RestRequest other) {
        if (other.isSetMethod()) {
            this.method = other.method;
        }
        if (other.isSetUri()) {
            this.uri = other.uri;
        }
        if (other.isSetParameters()) {
            Map<String, String> __this__parameters = new HashMap<String, String>();
            for (Map.Entry<String, String> other_element : other.parameters.entrySet()) {

                String other_element_key = other_element.getKey();
                String other_element_value = other_element.getValue();

                String __this__parameters_copy_key = other_element_key;

                String __this__parameters_copy_value = other_element_value;

                __this__parameters.put(__this__parameters_copy_key, __this__parameters_copy_value);
            }
            this.parameters = __this__parameters;
        }
        if (other.isSetHeaders()) {
            Map<String, String> __this__headers = new HashMap<String, String>();
            for (Map.Entry<String, String> other_element : other.headers.entrySet()) {

                String other_element_key = other_element.getKey();
                String other_element_value = other_element.getValue();

                String __this__headers_copy_key = other_element_key;

                String __this__headers_copy_value = other_element_value;

                __this__headers.put(__this__headers_copy_key, __this__headers_copy_value);
            }
            this.headers = __this__headers;
        }
        if (other.isSetBody()) {
            this.body = ByteBuffer.wrap(new byte[other.body.limit() - other.body.arrayOffset()]);
            System.arraycopy(other.body.array(), other.body.arrayOffset(), body.array(), 0, other.body.limit() - other.body.arrayOffset());
        }
    }

    public RestRequest deepCopy() {
        return new RestRequest(this);
    }

    @Deprecated
    public RestRequest clone() {
        return new RestRequest(this);
    }

    @Override
    public void clear() {
        this.method = null;
        this.uri = null;
        this.parameters = null;
        this.headers = null;
        this.body = null;
    }

    /**
     * @see org.elasticsearch.thrift.Method
     */
    public Method getMethod() {
        return this.method;
    }

    /**
     * @see org.elasticsearch.thrift.Method
     */
    public RestRequest setMethod(Method method) {
        this.method = method;
        return this;
    }

    public void unsetMethod() {
        this.method = null;
    }

    /**
     * Returns true if field method is set (has been asigned a value) and false otherwise
     */
    public boolean isSetMethod() {
        return this.method != null;
    }

    public void setMethodIsSet(boolean value) {
        if (!value) {
            this.method = null;
        }
    }

    public String getUri() {
        return this.uri;
    }

    public RestRequest setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public void unsetUri() {
        this.uri = null;
    }

    /**
     * Returns true if field uri is set (has been asigned a value) and false otherwise
     */
    public boolean isSetUri() {
        return this.uri != null;
    }

    public void setUriIsSet(boolean value) {
        if (!value) {
            this.uri = null;
        }
    }

    public int getParametersSize() {
        return (this.parameters == null) ? 0 : this.parameters.size();
    }

    public void putToParameters(String key, String val) {
        if (this.parameters == null) {
            this.parameters = new HashMap<String, String>();
        }
        this.parameters.put(key, val);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public RestRequest setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public void unsetParameters() {
        this.parameters = null;
    }

    /**
     * Returns true if field parameters is set (has been asigned a value) and false otherwise
     */
    public boolean isSetParameters() {
        return this.parameters != null;
    }

    public void setParametersIsSet(boolean value) {
        if (!value) {
            this.parameters = null;
        }
    }

    public int getHeadersSize() {
        return (this.headers == null) ? 0 : this.headers.size();
    }

    public void putToHeaders(String key, String val) {
        if (this.headers == null) {
            this.headers = new HashMap<String, String>();
        }
        this.headers.put(key, val);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public RestRequest setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public void unsetHeaders() {
        this.headers = null;
    }

    /**
     * Returns true if field headers is set (has been asigned a value) and false otherwise
     */
    public boolean isSetHeaders() {
        return this.headers != null;
    }

    public void setHeadersIsSet(boolean value) {
        if (!value) {
            this.headers = null;
        }
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public RestRequest setBody(ByteBuffer body) {
        this.body = body;
        return this;
    }

    public void unsetBody() {
        this.body = null;
    }

    /**
     * Returns true if field body is set (has been asigned a value) and false otherwise
     */
    public boolean isSetBody() {
        return this.body != null;
    }

    public void setBodyIsSet(boolean value) {
        if (!value) {
            this.body = null;
        }
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case METHOD:
                if (value == null) {
                    unsetMethod();
                } else {
                    setMethod((Method) value);
                }
                break;

            case URI:
                if (value == null) {
                    unsetUri();
                } else {
                    setUri((String) value);
                }
                break;

            case PARAMETERS:
                if (value == null) {
                    unsetParameters();
                } else {
                    setParameters((Map<String, String>) value);
                }
                break;

            case HEADERS:
                if (value == null) {
                    unsetHeaders();
                } else {
                    setHeaders((Map<String, String>) value);
                }
                break;

            case BODY:
                if (value == null) {
                    unsetBody();
                } else {
                    setBody((ByteBuffer) value);
                }
                break;

        }
    }

    public void setFieldValue(int fieldID, Object value) {
        setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case METHOD:
                return getMethod();

            case URI:
                return getUri();

            case PARAMETERS:
                return getParameters();

            case HEADERS:
                return getHeaders();

            case BODY:
                return getBody();

        }
        throw new IllegalStateException();
    }

    public Object getFieldValue(int fieldId) {
        return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
     */
    public boolean isSet(_Fields field) {
        switch (field) {
            case METHOD:
                return isSetMethod();
            case URI:
                return isSetUri();
            case PARAMETERS:
                return isSetParameters();
            case HEADERS:
                return isSetHeaders();
            case BODY:
                return isSetBody();
        }
        throw new IllegalStateException();
    }

    public boolean isSet(int fieldID) {
        return isSet(_Fields.findByThriftIdOrThrow(fieldID));
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof RestRequest)
            return this.equals((RestRequest) that);
        return false;
    }

    public boolean equals(RestRequest that) {
        if (that == null)
            return false;

        boolean this_present_method = true && this.isSetMethod();
        boolean that_present_method = true && that.isSetMethod();
        if (this_present_method || that_present_method) {
            if (!(this_present_method && that_present_method))
                return false;
            if (!this.method.equals(that.method))
                return false;
        }

        boolean this_present_uri = true && this.isSetUri();
        boolean that_present_uri = true && that.isSetUri();
        if (this_present_uri || that_present_uri) {
            if (!(this_present_uri && that_present_uri))
                return false;
            if (!this.uri.equals(that.uri))
                return false;
        }

        boolean this_present_parameters = true && this.isSetParameters();
        boolean that_present_parameters = true && that.isSetParameters();
        if (this_present_parameters || that_present_parameters) {
            if (!(this_present_parameters && that_present_parameters))
                return false;
            if (!this.parameters.equals(that.parameters))
                return false;
        }

        boolean this_present_headers = true && this.isSetHeaders();
        boolean that_present_headers = true && that.isSetHeaders();
        if (this_present_headers || that_present_headers) {
            if (!(this_present_headers && that_present_headers))
                return false;
            if (!this.headers.equals(that.headers))
                return false;
        }

        boolean this_present_body = true && this.isSetBody();
        boolean that_present_body = true && that.isSetBody();
        if (this_present_body || that_present_body) {
            if (!(this_present_body && that_present_body))
                return false;
            if (!this.body.equals(that.body))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(RestRequest other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        RestRequest typedOther = (RestRequest) other;

        lastComparison = Boolean.valueOf(isSetMethod()).compareTo(typedOther.isSetMethod());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetMethod()) {
            lastComparison = TBaseHelper.compareTo(this.method, typedOther.method);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetUri()).compareTo(typedOther.isSetUri());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetUri()) {
            lastComparison = TBaseHelper.compareTo(this.uri, typedOther.uri);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetParameters()).compareTo(typedOther.isSetParameters());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetParameters()) {
            lastComparison = TBaseHelper.compareTo(this.parameters, typedOther.parameters);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetHeaders()).compareTo(typedOther.isSetHeaders());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetHeaders()) {
            lastComparison = TBaseHelper.compareTo(this.headers, typedOther.headers);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetBody()).compareTo(typedOther.isSetBody());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetBody()) {
            lastComparison = TBaseHelper.compareTo(this.body, typedOther.body);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public void read(TProtocol iprot) throws TException {
        TField field;
        iprot.readStructBegin();
        while (true) {
            field = iprot.readFieldBegin();
            if (field.type == TType.STOP) {
                break;
            }
            switch (field.id) {
                case 1: // METHOD
                    if (field.type == TType.I32) {
                        this.method = Method.findByValue(iprot.readI32());
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 2: // URI
                    if (field.type == TType.STRING) {
                        this.uri = iprot.readString();
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 3: // PARAMETERS
                    if (field.type == TType.MAP) {
                        {
                            TMap _map0 = iprot.readMapBegin();
                            this.parameters = new HashMap<String, String>(2 * _map0.size);
                            for (int _i1 = 0; _i1 < _map0.size; ++_i1) {
                                String _key2;
                                String _val3;
                                _key2 = iprot.readString();
                                _val3 = iprot.readString();
                                this.parameters.put(_key2, _val3);
                            }
                            iprot.readMapEnd();
                        }
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 4: // HEADERS
                    if (field.type == TType.MAP) {
                        {
                            TMap _map4 = iprot.readMapBegin();
                            this.headers = new HashMap<String, String>(2 * _map4.size);
                            for (int _i5 = 0; _i5 < _map4.size; ++_i5) {
                                String _key6;
                                String _val7;
                                _key6 = iprot.readString();
                                _val7 = iprot.readString();
                                this.headers.put(_key6, _val7);
                            }
                            iprot.readMapEnd();
                        }
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 5: // BODY
                    if (field.type == TType.STRING) {
                        this.body = iprot.readBinary();
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                default:
                    TProtocolUtil.skip(iprot, field.type);
            }
            iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        validate();
    }

    public void write(TProtocol oprot) throws TException {
        validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (this.method != null) {
            oprot.writeFieldBegin(METHOD_FIELD_DESC);
            oprot.writeI32(this.method.getValue());
            oprot.writeFieldEnd();
        }
        if (this.uri != null) {
            oprot.writeFieldBegin(URI_FIELD_DESC);
            oprot.writeString(this.uri);
            oprot.writeFieldEnd();
        }
        if (this.parameters != null) {
            if (isSetParameters()) {
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
                {
                    oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.parameters.size()));
                    for (Map.Entry<String, String> _iter8 : this.parameters.entrySet()) {
                        oprot.writeString(_iter8.getKey());
                        oprot.writeString(_iter8.getValue());
                    }
                    oprot.writeMapEnd();
                }
                oprot.writeFieldEnd();
            }
        }
        if (this.headers != null) {
            if (isSetHeaders()) {
                oprot.writeFieldBegin(HEADERS_FIELD_DESC);
                {
                    oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.headers.size()));
                    for (Map.Entry<String, String> _iter9 : this.headers.entrySet()) {
                        oprot.writeString(_iter9.getKey());
                        oprot.writeString(_iter9.getValue());
                    }
                    oprot.writeMapEnd();
                }
                oprot.writeFieldEnd();
            }
        }
        if (this.body != null) {
            if (isSetBody()) {
                oprot.writeFieldBegin(BODY_FIELD_DESC);
                oprot.writeBinary(this.body);
                oprot.writeFieldEnd();
            }
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RestRequest(");
        boolean first = true;

        sb.append("method:");
        if (this.method == null) {
            sb.append("null");
        } else {
            sb.append(this.method);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("uri:");
        if (this.uri == null) {
            sb.append("null");
        } else {
            sb.append(this.uri);
        }
        first = false;
        if (isSetParameters()) {
            if (!first) sb.append(", ");
            sb.append("parameters:");
            if (this.parameters == null) {
                sb.append("null");
            } else {
                sb.append(this.parameters);
            }
            first = false;
        }
        if (isSetHeaders()) {
            if (!first) sb.append(", ");
            sb.append("headers:");
            if (this.headers == null) {
                sb.append("null");
            } else {
                sb.append(this.headers);
            }
            first = false;
        }
        if (isSetBody()) {
            if (!first) sb.append(", ");
            sb.append("body:");
            if (this.body == null) {
                sb.append("null");
            } else {
                TBaseHelper.toString(this.body, sb);
            }
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws TException {
        // check for required fields
        if (method == null) {
            throw new TProtocolException("Required field 'method' was not present! Struct: " + toString());
        }
        if (uri == null) {
            throw new TProtocolException("Required field 'uri' was not present! Struct: " + toString());
        }
    }

}

