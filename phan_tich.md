# PHÂN TÍCH VI PHẠM THIẾT KẾ TRONG ĐO HIỆU NĂNG THỦ CÔNG

Việc chèn thủ công đoạn code `System.currentTimeMillis()` vào đầu và cuối mỗi phương thức vi phạm nghiêm trọng các nguyên tắc thiết kế phần mềm cốt lõi sau:

### 1. Vi phạm nguyên tắc Single Responsibility Principle (SRP) - Nguyên lý đơn nhiệm
* **Lý do:** Một lớp hoặc một phương thức chỉ nên chịu một trách nhiệm duy nhất (ví dụ: `TransactionService` chỉ nên tập trung vào xử lý nghiệp vụ giao dịch ngân hàng).
* **Hệ quả:** Việc bắt phương thức này vừa phải xử lý logic thanh toán, vừa phải lo thêm việc đo đạc hiệu năng và ghi log khiến phương thức gánh vác quá nhiều trách nhiệm không liên quan.

### 2. Vi phạm nguyên tắc DRY (Don't Repeat Yourself)
* **Lý do:** Mã nguồn tính toán thời gian (`startTime`, `endTime`, phép trừ và câu lệnh in log) sẽ bị sao chép và lặp lại y hệt ở tất cả các hàm khác trong hệ thống.
* **Hệ quả:** Nếu sau này lead yêu cầu thay đổi cách ghi log (ví dụ: chuyển từ in ra Console sang dùng thư viện `Logger`, hoặc lưu vào Database), chúng ta sẽ phải đi sửa thủ công ở từng phương thức một. Việc này rất dễ gây sai sót và tốn công sức.

### 3. Gây ra hiện tượng Code Tangling (Đan xen mã) và Code Scattering (Phân tán mã)
* **Code Tangling:** Khối mã nghiệp vụ cốt lõi bị đan xen, trộn lẫn với các mã kỹ thuật (Cross-cutting Concerns) như bảo mật, log, transaction... làm code trở nên rối rắm, khó đọc.
* **Code Scattering:** Logic đo hiệu năng bị rải rác ở khắp mọi nơi trong hệ thống thay vì được quản lý tập trung tại một nơi duy nhất.