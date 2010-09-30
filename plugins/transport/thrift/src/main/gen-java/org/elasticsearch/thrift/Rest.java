/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.elasticsearch.thrift;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Rest {

    public interface Iface {

        public RestResponse execute(RestRequest request) throws TException;

    }

    public interface AsyncIface {

        public void execute(RestRequest request, AsyncMethodCallback<AsyncClient.execute_call> resultHandler) throws TException;

    }

    public static class Client implements TServiceClient, Iface {
        public static class Factory implements TServiceClientFactory<Client> {
            public Factory() {
            }

            public Client getClient(TProtocol prot) {
                return new Client(prot);
            }

            public Client getClient(TProtocol iprot, TProtocol oprot) {
                return new Client(iprot, oprot);
            }
        }

        public Client(TProtocol prot) {
            this(prot, prot);
        }

        public Client(TProtocol iprot, TProtocol oprot) {
            iprot_ = iprot;
            oprot_ = oprot;
        }

        protected TProtocol iprot_;
        protected TProtocol oprot_;

        protected int seqid_;

        public TProtocol getInputProtocol() {
            return this.iprot_;
        }

        public TProtocol getOutputProtocol() {
            return this.oprot_;
        }

        public RestResponse execute(RestRequest request) throws TException {
            send_execute(request);
            return recv_execute();
        }

        public void send_execute(RestRequest request) throws TException {
            oprot_.writeMessageBegin(new TMessage("execute", TMessageType.CALL, ++seqid_));
            execute_args args = new execute_args();
            args.setRequest(request);
            args.write(oprot_);
            oprot_.writeMessageEnd();
            oprot_.getTransport().flush();
        }

        public RestResponse recv_execute() throws TException {
            TMessage msg = iprot_.readMessageBegin();
            if (msg.type == TMessageType.EXCEPTION) {
                TApplicationException x = TApplicationException.read(iprot_);
                iprot_.readMessageEnd();
                throw x;
            }
            if (msg.seqid != seqid_) {
                throw new TApplicationException(TApplicationException.BAD_SEQUENCE_ID, "execute failed: out of sequence response");
            }
            execute_result result = new execute_result();
            result.read(iprot_);
            iprot_.readMessageEnd();
            if (result.isSetSuccess()) {
                return result.success;
            }
            throw new TApplicationException(TApplicationException.MISSING_RESULT, "execute failed: unknown result");
        }

    }

    public static class AsyncClient extends TAsyncClient implements AsyncIface {
        public static class Factory implements TAsyncClientFactory<AsyncClient> {
            private TAsyncClientManager clientManager;
            private TProtocolFactory protocolFactory;

            public Factory(TAsyncClientManager clientManager, TProtocolFactory protocolFactory) {
                this.clientManager = clientManager;
                this.protocolFactory = protocolFactory;
            }

            public AsyncClient getAsyncClient(TNonblockingTransport transport) {
                return new AsyncClient(protocolFactory, clientManager, transport);
            }
        }

        public AsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager clientManager, TNonblockingTransport transport) {
            super(protocolFactory, clientManager, transport);
        }

        public void execute(RestRequest request, AsyncMethodCallback<execute_call> resultHandler) throws TException {
            checkReady();
            execute_call method_call = new execute_call(request, resultHandler, this, protocolFactory, transport);
            manager.call(method_call);
        }

        public static class execute_call extends TAsyncMethodCall {
            private RestRequest request;

            public execute_call(RestRequest request, AsyncMethodCallback<execute_call> resultHandler, TAsyncClient client, TProtocolFactory protocolFactory, TNonblockingTransport transport) throws TException {
                super(client, protocolFactory, transport, resultHandler, false);
                this.request = request;
            }

            public void write_args(TProtocol prot) throws TException {
                prot.writeMessageBegin(new TMessage("execute", TMessageType.CALL, 0));
                execute_args args = new execute_args();
                args.setRequest(request);
                args.write(prot);
                prot.writeMessageEnd();
            }

            public RestResponse getResult() throws TException {
                if (getState() != State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                TMemoryInputTransport memoryTransport = new TMemoryInputTransport(getFrameBuffer().array());
                TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                return (new Client(prot)).recv_execute();
            }
        }

    }

    public static class Processor implements TProcessor {
        private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());

        public Processor(Iface iface) {
            iface_ = iface;
            processMap_.put("execute", new execute());
        }

        protected static interface ProcessFunction {
            public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
        }

        private Iface iface_;
        protected final HashMap<String, ProcessFunction> processMap_ = new HashMap<String, ProcessFunction>();

        public boolean process(TProtocol iprot, TProtocol oprot) throws TException {
            TMessage msg = iprot.readMessageBegin();
            ProcessFunction fn = processMap_.get(msg.name);
            if (fn == null) {
                TProtocolUtil.skip(iprot, TType.STRUCT);
                iprot.readMessageEnd();
                TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '" + msg.name + "'");
                oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
                x.write(oprot);
                oprot.writeMessageEnd();
                oprot.getTransport().flush();
                return true;
            }
            fn.process(msg.seqid, iprot, oprot);
            return true;
        }

        private class execute implements ProcessFunction {
            public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException {
                execute_args args = new execute_args();
                try {
                    args.read(iprot);
                } catch (TProtocolException e) {
                    iprot.readMessageEnd();
                    TApplicationException x = new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage());
                    oprot.writeMessageBegin(new TMessage("execute", TMessageType.EXCEPTION, seqid));
                    x.write(oprot);
                    oprot.writeMessageEnd();
                    oprot.getTransport().flush();
                    return;
                }
                iprot.readMessageEnd();
                execute_result result = new execute_result();
                result.success = iface_.execute(args.request);
                oprot.writeMessageBegin(new TMessage("execute", TMessageType.REPLY, seqid));
                result.write(oprot);
                oprot.writeMessageEnd();
                oprot.getTransport().flush();
            }

        }

    }

    public static class execute_args implements TBase<execute_args, execute_args._Fields>, java.io.Serializable, Cloneable {
        private static final TStruct STRUCT_DESC = new TStruct("execute_args");

        private static final TField REQUEST_FIELD_DESC = new TField("request", TType.STRUCT, (short) 1);

        public RestRequest request;

        /**
         * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
         */
        public enum _Fields implements TFieldIdEnum {
            REQUEST((short) 1, "request");

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
                    case 1: // REQUEST
                        return REQUEST;
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
            tmpMap.put(_Fields.REQUEST, new FieldMetaData("request", TFieldRequirementType.REQUIRED,
                    new StructMetaData(TType.STRUCT, RestRequest.class)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            FieldMetaData.addStructMetaDataMap(execute_args.class, metaDataMap);
        }

        public execute_args() {
        }

        public execute_args(
                RestRequest request) {
            this();
            this.request = request;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public execute_args(execute_args other) {
            if (other.isSetRequest()) {
                this.request = new RestRequest(other.request);
            }
        }

        public execute_args deepCopy() {
            return new execute_args(this);
        }

        @Deprecated
        public execute_args clone() {
            return new execute_args(this);
        }

        @Override
        public void clear() {
            this.request = null;
        }

        public RestRequest getRequest() {
            return this.request;
        }

        public execute_args setRequest(RestRequest request) {
            this.request = request;
            return this;
        }

        public void unsetRequest() {
            this.request = null;
        }

        /**
         * Returns true if field request is set (has been asigned a value) and false otherwise
         */
        public boolean isSetRequest() {
            return this.request != null;
        }

        public void setRequestIsSet(boolean value) {
            if (!value) {
                this.request = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
                case REQUEST:
                    if (value == null) {
                        unsetRequest();
                    } else {
                        setRequest((RestRequest) value);
                    }
                    break;

            }
        }

        public void setFieldValue(int fieldID, Object value) {
            setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
                case REQUEST:
                    return getRequest();

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
                case REQUEST:
                    return isSetRequest();
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
            if (that instanceof execute_args)
                return this.equals((execute_args) that);
            return false;
        }

        public boolean equals(execute_args that) {
            if (that == null)
                return false;

            boolean this_present_request = true && this.isSetRequest();
            boolean that_present_request = true && that.isSetRequest();
            if (this_present_request || that_present_request) {
                if (!(this_present_request && that_present_request))
                    return false;
                if (!this.request.equals(that.request))
                    return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public int compareTo(execute_args other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            execute_args typedOther = (execute_args) other;

            lastComparison = Boolean.valueOf(isSetRequest()).compareTo(typedOther.isSetRequest());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetRequest()) {
                lastComparison = TBaseHelper.compareTo(this.request, typedOther.request);
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
                    case 1: // REQUEST
                        if (field.type == TType.STRUCT) {
                            this.request = new RestRequest();
                            this.request.read(iprot);
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
            if (this.request != null) {
                oprot.writeFieldBegin(REQUEST_FIELD_DESC);
                this.request.write(oprot);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("execute_args(");
            boolean first = true;

            sb.append("request:");
            if (this.request == null) {
                sb.append("null");
            } else {
                sb.append(this.request);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws TException {
            // check for required fields
            if (request == null) {
                throw new TProtocolException("Required field 'request' was not present! Struct: " + toString());
            }
        }

    }

    public static class execute_result implements TBase<execute_result, execute_result._Fields>, java.io.Serializable, Cloneable {
        private static final TStruct STRUCT_DESC = new TStruct("execute_result");

        private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.STRUCT, (short) 0);

        public RestResponse success;

        /**
         * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
         */
        public enum _Fields implements TFieldIdEnum {
            SUCCESS((short) 0, "success");

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
                    case 0: // SUCCESS
                        return SUCCESS;
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
            tmpMap.put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT,
                    new StructMetaData(TType.STRUCT, RestResponse.class)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            FieldMetaData.addStructMetaDataMap(execute_result.class, metaDataMap);
        }

        public execute_result() {
        }

        public execute_result(
                RestResponse success) {
            this();
            this.success = success;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public execute_result(execute_result other) {
            if (other.isSetSuccess()) {
                this.success = new RestResponse(other.success);
            }
        }

        public execute_result deepCopy() {
            return new execute_result(this);
        }

        @Deprecated
        public execute_result clone() {
            return new execute_result(this);
        }

        @Override
        public void clear() {
            this.success = null;
        }

        public RestResponse getSuccess() {
            return this.success;
        }

        public execute_result setSuccess(RestResponse success) {
            this.success = success;
            return this;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        /**
         * Returns true if field success is set (has been asigned a value) and false otherwise
         */
        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean value) {
            if (!value) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
                case SUCCESS:
                    if (value == null) {
                        unsetSuccess();
                    } else {
                        setSuccess((RestResponse) value);
                    }
                    break;

            }
        }

        public void setFieldValue(int fieldID, Object value) {
            setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
                case SUCCESS:
                    return getSuccess();

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
                case SUCCESS:
                    return isSetSuccess();
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
            if (that instanceof execute_result)
                return this.equals((execute_result) that);
            return false;
        }

        public boolean equals(execute_result that) {
            if (that == null)
                return false;

            boolean this_present_success = true && this.isSetSuccess();
            boolean that_present_success = true && that.isSetSuccess();
            if (this_present_success || that_present_success) {
                if (!(this_present_success && that_present_success))
                    return false;
                if (!this.success.equals(that.success))
                    return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public int compareTo(execute_result other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            execute_result typedOther = (execute_result) other;

            lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetSuccess()) {
                lastComparison = TBaseHelper.compareTo(this.success, typedOther.success);
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
                    case 0: // SUCCESS
                        if (field.type == TType.STRUCT) {
                            this.success = new RestResponse();
                            this.success.read(iprot);
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
            oprot.writeStructBegin(STRUCT_DESC);

            if (this.isSetSuccess()) {
                oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
                this.success.write(oprot);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("execute_result(");
            boolean first = true;

            sb.append("success:");
            if (this.success == null) {
                sb.append("null");
            } else {
                sb.append(this.success);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws TException {
            // check for required fields
        }

    }

}
