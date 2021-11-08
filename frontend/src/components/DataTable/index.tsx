import axios from "axios";
import { useEffect, useState } from "react";
import { VendasPaginadas } from "types/venda";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/request";

const DataTable = () => {

    const [page, setPage] = useState<VendasPaginadas>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0 
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/vendas?page=0&size=20&sort=date,desc`)
            .then(response => {
                setPage(response.data);
            });
    }, []);

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(item => ( 
                        <tr key={item.id}>
                        <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                        <td>{item.vendedor.nome}</td>
                        <td>{item.visitado}</td>
                        <td>{item.promocoes}</td>
                        <td>{item.quantia.toFixed(2)}</td>
                    </tr>
                    ))}
                    
                </tbody>
            </table>
        </div>

    );
}

export default DataTable;
