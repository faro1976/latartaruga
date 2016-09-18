package it.framework.core.logging.log4j.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.MapMessage;

import it.framework.core.logging.impl.LoggerFactoryBinder;
import it.framework.core.logging.interf.IExecutionLogContext;
import it.framework.core.logging.interf.ILogContext;

public class LogEntry {

	private static final String VERSION_KEY = "pfVersion";
	private static String VERSION;

	private static final String MACHINE_NAME = "pfMachine";

	// LogContext
	private static final String CLIENT_ID = "pfClientId";
	private static final String SESSION_ID = "pfSessionId";
	private static final String TRACEABILITY_ID = "pfTraceabilityId";

	// generati
	private static final String EXECUTION_CONTEXT = "pfExecutionContext";
	private String executionContext;
	private static final String ENTRY_ID = "pfEntryId";

	// input
	private static final String OPERATION_ID = "pfOperationId";
	private String operationId;
	private static final String BUSINESS_ID = "pfBusinessId";
	private String businessId;
	private static final String STATUS = "pfStatus";
	private String pfStatus;
	private static final String IN_TRANSACTION = "pfInTransaction";
	private Boolean inTransaction;

	private static final String METHOD = "pfMethod";
	private Method pfMethod;
	private static final String PARAMS = "pfParams";
	private Object[] parameters;
	private static final String DURATION = "pfDuration";
	private Long pfDuration;

	private static final String MESSAGE = "pfMessage";
	private String pfMessage;

	public static final String METADATA = "pfMetadata";
	private Map<String, Object> pfMetadata;

	private Throwable throwable;

	static {
		InputStream is;
		try {
			is = LogEntry.class.getResource("/framework-logging-log4j.properties").openStream();
			Properties properties = new Properties();
			properties.load(is);
			VERSION = properties.getProperty("version");
			is.close();
		} catch (IOException e) {
			throw new FrameworkLoggingLog4jRuntimeExcpetion(
					"file di properties framework-logging-log4j.properties contenente la versione del logger non trovato",
					e);
		}
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public void setExcutionContext(String excutionContext) {
		this.executionContext = excutionContext;
	}

	public void setMessage(String message) {
		this.pfMessage = message;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.pfMetadata = metadata;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public void setDuration(long duration) {
		this.pfDuration = duration;
	}

	public void setMethod(Method method) {
		this.pfMethod = method;
	}

	public void setMethod(Method method, Object[] parameters) {
		this.pfMethod = method;
		this.parameters = parameters;
	}

	private static void initCommon(ILogContext logContext) {
		put(VERSION_KEY, VERSION);
		String hostname = "Unknown";
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			System.err.println("LogEntry Error: Hostname can not be resolved");
			LoggerFactoryBinder.getSingletonLog4J().getLogger("LogEntry").error("Hostname can not be resolved", ex);
		}
		put(MACHINE_NAME, hostname);

		put(CLIENT_ID, logContext.getClientId());
		put(SESSION_ID, logContext.getSessionId());
		put(TRACEABILITY_ID, logContext.getTraceabilityId());
	}

	static void initContext(ILogContext logContext) {
		initCommon(logContext);
		put(EXECUTION_CONTEXT, java.util.UUID.randomUUID().toString());
	}

	static void initContext(IExecutionLogContext executionLogContext) {
		initCommon(executionLogContext);
		put(EXECUTION_CONTEXT, executionLogContext.getExecutionId());
	}

	void log(Logger logger, org.apache.logging.log4j.Level level) {
		UUID entryId = java.util.UUID.randomUUID();
		LogEntryMessage msg = new LogEntryMessage();
		msg.add(OPERATION_ID, operationId);
		msg.add(BUSINESS_ID, businessId);
		msg.add(ENTRY_ID, entryId);
		msg.add(EXECUTION_CONTEXT, executionContext);
		msg.setMetadata(pfMetadata);
		msg.add(METHOD, pfMethod);
		if (parameters != null) {
			msg.add(PARAMS, Arrays.toString(parameters));
		}
		msg.add(DURATION, pfDuration);
		msg.add(STATUS, pfStatus);
		msg.add(IN_TRANSACTION, inTransaction);
		msg.add(MESSAGE, pfMessage);

		if (throwable == null) {
			logger.log(level, msg);
		} else {
			logger.log(level, msg, throwable);
		}
	}

	public static class LogEntryMessage extends MapMessage {
		private static final long serialVersionUID = 4044231104162003672L;
		private HashMap<String, Object> metadata;

		public LogEntryMessage(Map<String, String> data) {
			super(data);
		}

		public LogEntryMessage() {
			// Costruttore Vuoto
		}

		@Override
		public boolean equals(final Object o) {
			if (o == null) {
				return false;
			}

			if (!super.equals(o)) {
				return false;
			}

			if (metadata == null) {
				if (((LogEntryMessage) o).metadata != null) {
					return false;
				}
				return true;
			}

			return metadata.equals(((LogEntryMessage) o).metadata);
		}

		@Override
		public int hashCode() {
			if (metadata != null) {
				return super.hashCode() ^ metadata.hashCode();
			}
			return super.hashCode();
		}

		public Map<String, Object> getMetadata() {
			return metadata;
		}

		void add(String key, Object value) {
			if (value != null) {
				super.put(key, value.toString());
			}
		}

		public void setMetadata(Map<String, Object> map) {
			metadata = map != null ? new HashMap<>(map) : null;
			add(METADATA, metadata);
			if (metadata != null) {
				// per riferirsi ai singoli campi nel layout
				for (Entry<String, Object> item : metadata.entrySet()) {
					Object value = item.getValue();
					String s = value != null ? value.toString() : null;
					super.put(item.getKey(), s);
				}
			}
		}

	}

	private static void put(String key, String value) {
		if (value != null) {
			ThreadContext.put(key, value);
		}
	}

	public void setStatus(String status) {
		this.pfStatus = status;
	}

	public void setInTransaction(boolean inTransaction) {
		this.inTransaction = inTransaction;
	}

}
